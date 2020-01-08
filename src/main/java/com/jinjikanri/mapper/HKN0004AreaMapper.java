package com.jinjikanri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinjikanri.entity.HKN0004AreaEntity;

@Mapper
public interface HKN0004AreaMapper {
	List<HKN0004AreaEntity> getProvince();
	List<HKN0004AreaEntity> getCityOrCountry(Integer parentId);
	Integer selectAreaId(String areaName, Integer parentId);
}
