package com.jinjikanri.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jinjikanri.entity.HKN0001ORGEntity;
import com.jinjikanri.mapper.HKN0001Mapper;

import com.jinjikanri.service.HKN0001Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public  class HKN0001ServiceImpl implements HKN0001Service {
	@Autowired
	private HKN0001Mapper hkn0001Mapper;

	@Override
	public Map<String, Object> getOrganization(HKN0001ORGEntity orga,Integer offset,Integer limit) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, limit);
		Page<Object> page = PageHelper.startPage(offset, limit);
		List<HKN0001ORGEntity> orgaList = hkn0001Mapper.getOrganization(orga, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("orgaList", orgaList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}
	@Override
	public HKN0001ORGEntity deleteOrgazization(Integer organizationCd) {
		return hkn0001Mapper.deleteOrgazization(organizationCd);

	}
	
	@Override
	public HKN0001ORGEntity selectUserById(Integer organizationCd) {
		return hkn0001Mapper.selectUserById(organizationCd);
	}
	@Override
	public int updateorganizationCd(HKN0001ORGEntity orga) {
		return hkn0001Mapper.updateorganizationCd(orga);
	}

	@Override
	public int insertorganizationCd(HKN0001ORGEntity orga) {
		return hkn0001Mapper.insertganizationCd(orga);
	}
	@Override
	public int insert1organizationCd(HKN0001ORGEntity orga) {
		return hkn0001Mapper.insertganizationCd(orga);
	}
	@Override
	public int update1organizationCd(HKN0001ORGEntity orga) {
		return hkn0001Mapper.update1organizationCd(orga);
	}

}
