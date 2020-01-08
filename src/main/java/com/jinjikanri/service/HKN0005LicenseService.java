package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.Map;

import com.jinjikanri.entity.HKN0005LicenseEntity;

public interface HKN0005LicenseService {
	/* シャトルバスの情報を検索する。 */
	public Map<String, Object> selectBus(HKN0005LicenseEntity hkn0005LicenseEntity, int offset);

	/* バスIDは存在チェック。 */
	public HKN0005LicenseEntity selectBusById(Integer busId);

	/* シャトルバスの情報を追加する。 */
	public int busInsert(HKN0005LicenseEntity hkn0005LicenseEntity);

	/* シャトルバスの情報を変更する。 */
	public int busUpdate(HKN0005LicenseEntity hkn0005LicenseEntity);

	/* シャトルバスの情報を削除する。 */
	int busDelete(Integer busId, Timestamp recKosnZituYmdHms);

	/* DBチェック。 */
	public HKN0005LicenseEntity selectDB(Integer busId, Timestamp recKosnZituYmdHms);

	/* シャトルバスの情報は存在チェック。 */
	public Map<Integer, String> selectBusId(Integer classes, Integer staffCd, String licenseId);

}
