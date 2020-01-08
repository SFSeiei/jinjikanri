package com.jinjikanri.service;

import java.util.List;

import com.jinjikanri.entity.HKN0004AreaEntity;

public interface HKN0004AreaService {
	public List<HKN0004AreaEntity> getProvince();
	public List<HKN0004AreaEntity> getCityOrCountry(Integer parentId);
	public Integer selectAreaId(String areaName, Integer parentId);
}
