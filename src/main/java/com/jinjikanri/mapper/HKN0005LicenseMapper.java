package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.HKN0005LicenseEntity;

/**
 * 
 * DB操作<BR>
 * DB詳細操作の実行
 * @author 田柳　2020/01/08
 *
 */
@Mapper
public interface HKN0005LicenseMapper {
	/**
	 * シャトルバスの情報を検索する。
	 * @param hkn0005LicenseEntity
	 * @param rowBounds
	 * @return
	 */
	List<HKN0005LicenseEntity> selectBus(HKN0005LicenseEntity hkn0005LicenseEntity, RowBounds rowBounds);
	
	/**
	 * バスIDは存在チェック。
	 * @param userId
	 * @return
	 */
	HKN0005LicenseEntity selectBusById(Integer userId);
	
	/**
	 * シャトルバスの情報を追加する。
	 * @param hkn0005LicenseEntity
	 * @return
	 */
	int busInsert(HKN0005LicenseEntity hkn0005LicenseEntity);
	
	/**
	 * シャトルバスの情報を変更する。
	 * @param hkn0005LicenseEntity
	 * @return
	 */
	int busUpdate(HKN0005LicenseEntity hkn0005LicenseEntity);
	
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
	HKN0005LicenseEntity selectDB(Integer busId, Timestamp recKosnZituYmdHms);
	
	/**
	 * シャトルバスの情報は存在チェック。
	 * @param busId
	 * @param classes
	 * @param staffCd
	 * @param licenseId
	 * @return
	 */
	List<HKN0005LicenseEntity> selectBusId(Integer busId, Integer classes, Integer staffCd, String licenseId);

}
