package com.jinjikanri.service;

import java.sql.Timestamp;

import com.jinjikanri.entity.HKN0010ZyuyntsEntity;

/**
 * 
 * @author 史林林 2019/12/30
 */
public interface ZyuyService {

	/**
	 * 剰余日数と出勤時刻情報取得。
	 * @param sttCd 設定コード
     */
	HKN0010ZyuyntsEntity getZyuyById(Integer sttCd);
	
	/**
	 * 剰余日数と出勤時刻情報变更する。
	 * @param zyuy 剰余日数と出勤時刻情報
	 * @return 
     */
	void updateZyuyById(HKN0010ZyuyntsEntity zyuy);
	
	/**
	 * 剰余日数と出勤時刻情報排他クエリーする
	 * @param sttCd 設定コード
	 * @param reckosnzituymdhms レコード更新実年月日時分秒
     */
	boolean selectDB(Integer sttCd, Timestamp recKosnZituYmdHms);


}
