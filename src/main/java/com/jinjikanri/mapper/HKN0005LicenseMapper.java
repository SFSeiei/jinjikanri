package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.HKN0005LicenseEntity;

@Mapper
public interface HKN0005LicenseMapper {
	/* シャトルバスの情報を検索する。 */
	List<HKN0005LicenseEntity> selectBus(HKN0005LicenseEntity hkn0005LicenseEntity, RowBounds rowBounds);

	/* バスIDは存在チェック。 */
	HKN0005LicenseEntity selectBusById(Integer userId);

	/* シャトルバスの情報を追加する。 */
	int busInsert(HKN0005LicenseEntity hkn0005LicenseEntity);

	/* シャトルバスの情報を変更する。 */
	int busUpdate(HKN0005LicenseEntity hkn0005LicenseEntity);

	/* シャトルバスの情報を削除する。 */
	int busDelete(Integer busId, Timestamp recKosnZituYmdHms);

	/* DBチェック。 */
	HKN0005LicenseEntity selectDB(Integer busId, Timestamp recKosnZituYmdHms);

	/* シャトルバスの情報は存在チェック。 */
	List<HKN0005LicenseEntity> selectBusId(Integer classes, Integer staffCd, String licenseId);

}
