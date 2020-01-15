package com.jinjikanri.service;

import java.util.List;

import com.jinjikanri.entity.HKN0004AreaEntity;
/**
 * ビジネスロジックインターフェース
 * @author 刁家豪　2020/01/10
 */
public interface HKN0004AreaService {
	/**
	 * すべての省を検索
	 */
	public List<HKN0004AreaEntity> getProvince();
	/**
	 * 省（市）によって市（区、県）を照会する。
	 */
	public List<HKN0004AreaEntity> getCityOrCountry(Integer parentId);
	/**
	 * 地域IDの取得
	 */
	public Integer selectAreaId(String areaName, Integer parentId);
}
