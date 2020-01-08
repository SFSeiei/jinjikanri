package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.entity.JIN0006AdmitEntity;
import com.jinjikanri.mapper.AdmitMapper;
import com.jinjikanri.service.AdmitService;
@Service

public class AdmitServiceImpl implements AdmitService {
	@Autowired
	private AdmitMapper admitMapper;
	
	
	@Override
	public Map<String, Object> selectAdmit(JIN0006AdmitEntity admit,int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<JIN0006AdmitEntity> admitList = this.admitMapper.selectAdmit(admit, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("admitList", admitList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}
	
	@Override
	public Map<String, Object> selectAdmit2(JIN0006AdmitEntity admit,int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<JIN0006AdmitEntity> admitList = this.admitMapper.selectAdmit2(admit, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("admitList", admitList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}
	
	@Override
	public JIN0006AdmitEntity selectAdmitById(Integer dateId) {
		return this.admitMapper.selectAdmitById(dateId);
	}
	
	@Override
	public JIN0006AdmitEntity selectById(Integer dateId) {
		return this.admitMapper.selectAdmitById(dateId);
	}
	
	@Override
	public int updateAdmitById(JIN0006AdmitEntity admit) {
		return admitMapper.updateAdmitById(admit);
	}

	@Override
	public JIN0006AdmitEntity getDataByIdTime(Integer dateId,Timestamp recSaksZituYmdHms) {
		return admitMapper.getDataByIdTime(dateId, recSaksZituYmdHms);
	}
 
}
