package com.jinjikanri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinjikanri.entity.HKN0004AreaEntity;
import com.jinjikanri.mapper.HKN0004AreaMapper;
import com.jinjikanri.service.HKN0004AreaService;
/**
 * 地域情報の業務ロジック
 * @author 刁家豪　2020/01/10
 */
@Service
public class HKN0004AreaServiceImpl implements HKN0004AreaService {
	@Autowired
	private HKN0004AreaMapper hkn0004AreaMapper;
	/**
	 * すべての省を検索
	 * @return 省リスト
	 */
	@Override
	public List<HKN0004AreaEntity> getProvince() {
		return hkn0004AreaMapper.getProvince();
	}
	/**
	 * 省（市）によって市（区、県）を照会する。
	 * @return 市/区/県リスト
	 */
	@Override
	public List<HKN0004AreaEntity> getCityOrCountry(Integer parentId) {
		return hkn0004AreaMapper.getCityOrCountry(parentId);
	}	
	/**
	 * 地域IDの取得
	 * @return 地域ID
	 */
	@Override
	public Integer selectAreaId(String areaName, Integer parentId) {
		// TODO Auto-generated method stub
		return hkn0004AreaMapper.selectAreaId(areaName, parentId);
	}

}
