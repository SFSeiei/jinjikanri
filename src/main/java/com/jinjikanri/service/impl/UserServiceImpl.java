package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.Md5;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.mapper.UserCharRightRelMapper;
import com.jinjikanri.mapper.UserMapper;
import com.jinjikanri.service.UserCharRightRelService;
import com.jinjikanri.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CharMapper charMapper;

	@Autowired
	private UserCharRightRelMapper userCharRightRelMapper;

	@Autowired
	private UserCharRightRelService userCharRightRelService;

	@Override
	public Map<String, Object> selectUsers(SYST01UserEntity user, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<SYST01UserEntity> userList = this.userMapper.selectUsers(user, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("userList", userList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}

	@Override
	public SYST01UserEntity selectUserByUsrCd(Integer usrCd) {
		return this.userMapper.selectUserByUsrCd(usrCd);
	}

	@Override
	public SYST01UserEntity selectUserByUsrId(String usrId) {
		return this.userMapper.selectUserByUsrId(usrId);
	};

	@Override
	public boolean saveUser(SYST01UserEntity user, List<Integer> charCdList) throws Exception {
		/**
		 * 对所有人的usrId进行重复审查，如有重复，抛出异常
		 */
		Map<String, Object> result = this.selectUsers(new SYST01UserEntity(), 1);
		List<SYST01UserEntity> userList = (List<SYST01UserEntity>) result.get("userList");
		for (SYST01UserEntity oneuser : userList) {
			if (user.getUsrId().equals(oneuser.getUsrId())) {
				throw new Exception();
			}
		}
		// レコード作成実年月日時分秒を設定する。
		user.setRecSaksZituYmdHms(Tools.getSysDate());
		user.setRecKosnZituYmdHms(Tools.getSysDate());
		/*
		 * 对密码进行加密
		 */
		// 使用MD5加密
		String hashAlgorithmName = "MD5";
		// 以用户usrId进行盐值加密
		Object salt = ByteSource.Util.bytes(user.getUsrId());
		// 进行加密
		String encryResult = new SimpleHash(hashAlgorithmName, user.getPasswd(), salt, 1024).toHex();
		// 将加密后的密码设置到用户属性中
		user.setPasswd(encryResult);
		userMapper.saveUser(user);
		SYST01UserEntity dbUser = userMapper.selectUserByUsrId(user.getUsrId());
		// 同时根据charCdList创建用户角色关系
		userCharRightRelService.saveOrUpdateUCRel(dbUser.getUsrCd(), charCdList);
		return true;
	}

	@Override
	public String updateUser(String updateTime, SYST01UserEntity user, List<Integer> charCdList) {
		String message = null;
		if (StringUtils.isBlank(user.getPasswd())) {
			user.setPasswd(null);
		} else {
			String encryResult = Md5.encode(user.getPasswd(), user.getUsrId());
			user.setPasswd(encryResult);
		}
		// 画面のUsrCdを取得する
		Integer usrCd = user.getUsrCd();
		Timestamp updateTimeDate = Tools.transStringToTimestamp(updateTime);
		// 更新されたデータを検索
		SYST01UserEntity dbUserEntity = this.userMapper.selectUserByUsrCd(usrCd);
		if (dbUserEntity == null) {
			// 更新されたデータは存在しませんエラー
			message = ErrorMessage.ERR0029();
		} else {
			// DB更新排他チェック
			if (!dbUserEntity.getRecKosnZituYmdHms().equals(updateTimeDate)) {
				// 更新排他エラー
				message = ErrorMessage.ERR0048();
			} else {
				// DB更新操作を実行する
				user.setRecKosnZituYmdHms(Tools.getSysDate());
				if (userMapper.updateUser(user)) {
					// 保存用户与角色关系
					userCharRightRelService.saveOrUpdateUCRel(user.getUsrCd(), charCdList);
					// 更新成功
					message = "updateSucess";
				} else {
					// 更新失敗
					message = "updateFail";
				}
			}
		}
		return message;
	}

	@Override
	public boolean updateUserPassword(Integer usrCd, String password, String newPassword, String updateTime) {
		List<SYST06CharEntity> charlist = charMapper.selectCharListByUsrCd(usrCd);
		List<Integer> charCdList = new ArrayList<>();
		for (SYST06CharEntity oneChar : charlist) {
			charCdList.add(oneChar.getCharCd());
		}
		SYST01UserEntity dbUserEntity = this.userMapper.selectUserByUsrCd(usrCd);
		// 进行加密
		String encryResult = Md5.encode(password, dbUserEntity.getUsrId());
		// 判断原密码。没有加密对比。
		if (dbUserEntity.getPasswd().equals(encryResult)) {
			dbUserEntity.setPasswd(newPassword);
			if (this.updateUser(updateTime, dbUserEntity, charCdList) == "updateSucess") {
				return true;
			} else {
				return false;
			}
		} else
			// 此处应该报密码不一致异常而不是返回false.
			return false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteUserBatch(Integer[] usrCds) {
		// 先根据usrCds删除关系
		for (Integer usrCd : usrCds) {
			this.userCharRightRelMapper.removeRelByUsrCd(usrCd);
		}
		// 再删除用户
		return this.userMapper.deleteUserBatch(usrCds);

	}
}
