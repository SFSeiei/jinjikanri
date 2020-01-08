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
import com.jinjikanri.entity.SYST06RightEntity;
import com.jinjikanri.mapper.RightMapper;
import com.jinjikanri.mapper.UserCharRightRelMapper;
import com.jinjikanri.service.RightService;

@Service
public class RightServiceImpl implements RightService {
	@Autowired
	private RightMapper rightMapper;

	@Autowired
	private UserCharRightRelMapper userCharRightRelMapper;

	@Override
	public Map<String, Object> selectRights(SYST06RightEntity rightEntity, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<SYST06RightEntity> rightList = this.rightMapper.selectRights(rightEntity, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("rightList", rightList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean saveRight(SYST06RightEntity rightEntity) {
		return this.rightMapper.saveRight(rightEntity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateRight(SYST06RightEntity rightEntity) {
		return this.rightMapper.updateRight(rightEntity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteRightBatch(Integer[] rightCds) {
		// 先根据rightCds删除关系
		for (Integer rightCd : rightCds) {
			userCharRightRelMapper.removeRelByRightCd(rightCd);
		}
		// 再删除权限
		return this.rightMapper.deleteRightBatch(rightCds);
	}
}
