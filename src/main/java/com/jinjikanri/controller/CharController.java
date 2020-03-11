package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.config.CustomRealm;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.common.util.UserCheck;
import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.entity.SYST06RightEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.mapper.RightMapper;
import com.jinjikanri.service.CharService;

/**
 * 角色管理
 *
 * @author zhangxuping
 */
@Controller
@RequestMapping("/sys/char")
public class CharController {
	@Autowired
	private CharMapper charMapper;

	@Autowired
	private RightMapper rightMapper;

	@Autowired
	private CharService charService;

	/**
	 * 列表方法，带分页
	 * 
	 * @param           char
	 * @param pageIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectChars")
	public String selectChars(SYST06CharEntity charEntity, Integer pageIndex, Model model) {
		if (charEntity.getCharMei() == "") {
			charEntity.setCharMei(null);
		}
		if (charEntity.getCharDhiskrpsn() == "") {
			charEntity.setCharDhiskrpsn(null);
		}
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.charService.selectChars(charEntity, pageIndex);
		List<SYST06CharEntity> charList = (List<SYST06CharEntity>) result.get("charList");
		for (int i = 0; i < charList.size(); i++) {
			SYST06CharEntity oneChar = charList.get(i);
			if (oneChar.getCharMei().toString().equals("sysAdmin")) {
				charList.remove(i);
				i--;
			}
		}
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("charList", charList);
		model.addAttribute("char", charEntity);
		return "char/list";
	}

	@RequestMapping(value = "/oper")
	public String oper(Integer charCd, Model model) {
		SYST06CharEntity charEntity = new SYST06CharEntity();
		List<SYST06RightEntity> charRightList = new ArrayList<SYST06RightEntity>();
		if (charCd != null) {
			RowBounds rowBounds = new RowBounds();
			charEntity.setCharCd(charCd);
			for (SYST06CharEntity oneChar : this.charMapper.selectChars(charEntity, rowBounds)) {
				if (oneChar.getCharMei().toString().equals("sysAdmin")) {
					charEntity = new SYST06CharEntity();
					model.addAttribute("msg", "このキャラクターは変更できません。");
				} else {
					charEntity = oneChar;
					charRightList = this.rightMapper.selectRightListByCharCd(charCd);
				}
			}
		}
		model.addAttribute("char", charEntity);
		List<Integer> rightCdList = new ArrayList<Integer>();
		for (SYST06RightEntity oneCharRight : charRightList) {
			rightCdList.add(oneCharRight.getRightCd());
		}
		model.addAttribute("rightCdList", rightCdList);
		return "char/oper";
	}

	/**
	 * 保存角色
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(String rightCdList, SYST06CharEntity charEntity) {
		String message = new String();
		if (charEntity.getCharMei().toString().equals("sysAdmin")) {
			message = "名前を追加できないのは'sysAdmin'のキャラクターです";
		} else {
			List<Integer> rightCdLists = new ArrayList<>();
			if (!rightCdList.isEmpty() && rightCdList != "" && rightCdList != null) {
				for (String rightCd : rightCdList.split(",")) {
					rightCdLists.add(Integer.valueOf(rightCd));
				}
			}
			if (this.charService.saveChar(charEntity, rightCdLists)) {
				message = "新規に成功しました。";
			} else {
				message = "新規に失敗しました、更新してから送信してください";
			}
		}
		return message;
	}

	/**
	 * 修改角色
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(String updateTime, String rightCdList, SYST06CharEntity charEntity) {
		String message = new String();
		if (charEntity.getCharMei().toString().equals("sysAdmin")) {
			message = "このキャラクターは変更できません。";
		} else {
			List<Integer> rightCdLists = new ArrayList<>();
			if (!rightCdList.isEmpty() && rightCdList != "" && rightCdList != null) {
				for (String rightCd : rightCdList.split(",")) {
					rightCdLists.add(Integer.valueOf(rightCd));
				}
			}
			message = this.charService.updateChar(updateTime, charEntity, rightCdLists);
			switch (message) {
			case "updateSucess":
				message = "更新に成功しました。";
				break;
			case "updateFail":
				message = "更新に失敗しました、更新してから送信してください";
				break;
			default:
				break;
			}
			// 添加成功之后 清除缓存
			DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
			CustomRealm shiroRealm = (CustomRealm) securityManager.getRealms().iterator().next();
			// 清除用户认证相关的缓存
			shiroRealm.clearAllCachedAuthenticationInfo();
		}
		return message;
	}

	/**
	 * 删除角色
	 */
	@RequestMapping("/delete")
	public String delete(Integer[] charCds, Model model) {
		SYST06CharEntity nullChar = new SYST06CharEntity();
		for (int i = 0; i < charCds.length; i++) {
			nullChar.setCharCd(charCds[i]);
			List<SYST06CharEntity> charList = this.charMapper.selectChars(nullChar, new RowBounds());
			for (SYST06CharEntity charEntity : charList) {
				if (charEntity.getCharMei().toString().equals("sysAdmin")) {
					charCds = UserCheck.arrayDelete(i, charCds);
				}
			}
		}
		if (charCds.length != 0) {
			this.charService.deleteCharBatch(charCds);
		}
		nullChar = new SYST06CharEntity();
		// 添加成功之后 清除缓存
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		CustomRealm shiroRealm = (CustomRealm) securityManager.getRealms().iterator().next();
		// 清除用户认证相关的缓存
		shiroRealm.clearAllCachedAuthenticationInfo();
		return this.selectChars(nullChar, 1, model);
	}

	/**
	 * 角色列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public HashMap<String, List<SYST06CharEntity>> list() {
		List<SYST06CharEntity> charList = charMapper.selectChars(new SYST06CharEntity(), new RowBounds());
		for (int i = 0; i < charList.size(); i++) {
			SYST06CharEntity oneChar = charList.get(i);
			if (oneChar.getCharMei().toString().equals("sysAdmin")) {
				charList.remove(i);
				i--;
			}
		}
		HashMap<String, List<SYST06CharEntity>> charListMap = new HashMap<>();
		charListMap.put("charList", charList);
		return charListMap;
	}

	/**
	 * 根据UsrCd获取角色列表
	 */
	@RequestMapping("/listbyUsrCd")
	@ResponseBody
	public HashMap<String, List<SYST06CharEntity>> listByUserCd(Integer usrCd) {
		List<SYST06CharEntity> charList = charMapper.selectCharListByUsrCd(usrCd);
		for (int i = 0; i < charList.size(); i++) {
			SYST06CharEntity oneChar = charList.get(i);
			if (oneChar.getCharMei().toString().equals("sysAdmin")) {
				charList.remove(i);
				i--;
			}
		}
		HashMap<String, List<SYST06CharEntity>> charListMap = new HashMap<>();
		charListMap.put("charList", charList);
		return charListMap;
	}
}
