package com.jinjikanri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinjikanri.entity.HKN0004AreaEntity;
import com.jinjikanri.mapper.HKN0004AreaMapper;
import com.jinjikanri.service.HKN0004AreaService;

@Service
public class HKN0004AreaServiceImpl implements HKN0004AreaService {
	@Autowired
	private HKN0004AreaMapper hkn0004AreaMapper;
	
	@Override
	public List<HKN0004AreaEntity> getProvince() {
		return hkn0004AreaMapper.getProvince();
	}

	@Override
	public List<HKN0004AreaEntity> getCityOrCountry(Integer parentId) {
		return hkn0004AreaMapper.getCityOrCountry(parentId);
	}

	@Override
	public Integer selectAreaId(String areaName, Integer parentId) {
		// TODO Auto-generated method stub
		return hkn0004AreaMapper.selectAreaId(areaName, parentId);
	}

}
