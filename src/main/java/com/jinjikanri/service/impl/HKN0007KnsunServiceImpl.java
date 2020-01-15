package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinjikanri.entity.HKN0007KnsunEntity;
import com.jinjikanri.mapper.HKN0007KnsunMapper;
import com.jinjikanri.service.HKN0007KnsunService;

/**
 * “健診日の管理 ”の業務ロジック
 * @author 李春菊
 *
 */
@Service
public class HKN0007KnsunServiceImpl implements HKN0007KnsunService {
	
	@Autowired
	private HKN0007KnsunMapper hkn0007KnsunMapper;
	/**
	 * 健診日下の引張り方法を実現する
	 */
	@Override
	public List<HKN0007KnsunEntity> hkn0007KnsunEntities() {
		return this.hkn0007KnsunMapper.hkn0007KnsunEntities();
	}
	/**
	 * 新規追加の方法
	 */
	@Override
	public int insertKnsun(HKN0007KnsunEntity knsun) {
		//	新規に追加したDBcheckは,HKN0007KnsunMapperでメソッドdataValidを呼び出し,結果list集合を得る
		List<HKN0007KnsunEntity> knsunEntities = this.hkn0007KnsunMapper.dataValid(knsun);
		if (knsunEntities.size() > 0) {
			return 2;
		}
		return hkn0007KnsunMapper.insertKnsun(knsun);
	}
	/**
	 * IDにより健診日情報を取得する
	 */
	@Override
	public HKN0007KnsunEntity getKnsunById(Integer knsun) {
		return hkn0007KnsunMapper.getKnsunById(knsun);
	}
	/**
	 * 削除の方法
	 */
	@Override
	public int deleteKnsun(Integer knsunId) {
		return hkn0007KnsunMapper.deleteKnsun(knsunId);
	}
	/**
	 * 変更の方法
	 */
	@Override
	public int updateKnsunById(HKN0007KnsunEntity knsun) {
		List<HKN0007KnsunEntity> knsunEntities = this.hkn0007KnsunMapper.dataValid(knsun);
		if (knsunEntities.size() > 0) {
			return 2;
		}
		return hkn0007KnsunMapper.updateKnsunById(knsun);
	}
	/**
	 * 排他
	 */
	@Override
	public HKN0007KnsunEntity getKnsunByIdAndUpdateTime(Integer knsunId, Timestamp recKosnZituYmdHms) {
		return hkn0007KnsunMapper.getKnsunByIdAndUpdateTime(knsunId, recKosnZituYmdHms);
	}
	/**
	 * クエリの方法
	 */
	@Override
	public List<HKN0007KnsunEntity> selectKnsun(List<Integer> knsunIdList) {
		return hkn0007KnsunMapper.selectKnsun(knsunIdList);
	}
}
