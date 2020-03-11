package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.Map;

import com.jinjikanri.entity.HKN0005LicenseEntity;

/**
 * 
 * @author 田柳　2020/01/08
 *
 */
public interface HKN0005LicenseService {
	/**
	 * シャトルバスの情報を検索する。
	 * @param hkn0005LicenseEntity
	 * @param offset
	 * @return
	 */
	public Map<String, Object> selectBus(HKN0005LicenseEntity hkn0005LicenseEntity, int offset);
	
	/**
	 * バスIDは存在チェック。
	 * @param busId
	 * @return
	 */
	public HKN0005LicenseEntity selectBusById(Integer busId);
	
	/**
	 * シャトルバスの情報を追加する。
	 * @param hkn0005LicenseEntity
	 * @return
	 */
	public int busInsert(HKN0005LicenseEntity hkn0005LicenseEntity);
	
	/**
	 * シャトルバスの情報を変更する。
	 * @param hkn0005LicenseEntity
	 * @return
	 */
	public int busUpdate(HKN0005LicenseEntity hkn0005LicenseEntity);
	
	/**
	 * シャトルバスの情報を削除する。
	 * @param busId
	 * @param recKosnZituYmdHms
	 * @return
	 */
	int busDelete(Integer busId, Timestamp recKosnZituYmdHms);
	
	/**
	 * DBチェック。
	 * @param busId
	 * @param recKosnZituYmdHms
	 * @return
	 */
	public HKN0005LicenseEntity selectDB(Integer busId, Timestamp recKosnZituYmdHms);
	
	/**
	 * シャトルバスの情報は存在チェック。
	 * @param busId
	 * @param classes
	 * @param staffCd
	 * @param licenseId
	 * @return
	 */
	public Map<Integer, String> selectBusId(Integer busId, Integer classes, Integer staffCd, String licenseId);

}
