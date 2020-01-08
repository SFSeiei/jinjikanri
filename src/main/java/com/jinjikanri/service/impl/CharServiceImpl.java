package com.jinjikanri.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.mapper.UserCharRightRelMapper;
import com.jinjikanri.service.CharService;
import com.jinjikanri.service.UserCharRightRelService;

@Service
public class CharServiceImpl implements CharService {

	@Autowired
	private CharMapper charMapper;

	@Autowired
	private UserCharRightRelMapper userCharRightRelMapper;

	@Autowired
	private UserCharRightRelService userCharRightRelService;

	@Override
	public Map<String, Object> selectChars(SYST06CharEntity charEntity, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<SYST06CharEntity> charList = this.charMapper.selectChars(charEntity, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("charList", charList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean saveChar(SYST06CharEntity charEntity, List<Integer> rightCdList) {
		this.charMapper.saveChar(charEntity);
		// 保存角色与菜单关系
		return userCharRightRelService.saveOrUpdateCRRel(charEntity.getCharCd(), rightCdList);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateChar(SYST06CharEntity charEntity, List<Integer> rightCdList) {
		this.charMapper.updateChar(charEntity);
		// 更新角色与菜单关系
		return userCharRightRelService.saveOrUpdateCRRel(charEntity.getCharCd(), rightCdList);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteCharBatch(Integer[] charCds) {
		// 先根据charCds删除关系
		for (Integer charCd : charCds) {
			this.userCharRightRelMapper.removeRelByCharCd(charCd);
		}
		// 再删除角色
		return this.charMapper.deleteCharBatch(charCds);

	}
}
