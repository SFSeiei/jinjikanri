package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.List;

import com.jinjikanri.entity.HKN0007KnsunEntity;

public interface HKN0007KnsunService {
	/**
	 * 健診日下の引張り方法を実現する
	 * @return
	 */
	List<HKN0007KnsunEntity> hkn0007KnsunEntities();
	/**
	 * クエリの方法
	 * @param knsunIdList
	 * @return
	 */
	public List<HKN0007KnsunEntity> selectKnsun(List<Integer> knsunIdList);
	/**
	 * 新規追加の方法
	 * @param knsun
	 * @return
	 */
	public int insertKnsun(HKN0007KnsunEntity knsun);
	/**
	 * IDにより健診日情報を取得する
	 * @param knsun
	 * @return
	 */
	public HKN0007KnsunEntity getKnsunById(Integer knsun);
	/**
	 * 排他
	 * @param knsunId
	 * @param recKosnZituYmdHms
	 * @return
	 */
	public HKN0007KnsunEntity getKnsunByIdAndUpdateTime(Integer knsunId,Timestamp recKosnZituYmdHms);
	/**
	 * 削除の方法
	 * @param knsunId
	 * @return
	 */
	public int deleteKnsun(Integer knsunId);
	/**
	 * 変更の方法
	 * @param knsun
	 * @return
	 */
	public int updateKnsunById(HKN0007KnsunEntity knsun);
}
