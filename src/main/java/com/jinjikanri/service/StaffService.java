package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.jinjikanri.entity.JIN0002StaffEntity;

/**
 * DB操作<BR>
 * DB詳細操作の実行
 * @author 陳俊霖　2019/12/27
 */
public interface StaffService {

	/**
	 * 人員基本情報取得改ページ表示。
	 * @param staffEntity 人員基本情報
	 * @param offset
	 */
	public Map<String, Object> selectStaffs(
			JIN0002StaffEntity staffEntity, Integer offset);

	/**
	 * 人員基本情報取得。
	 * @param idNumber 証件番号
	 * @return なし
     */
	public JIN0002StaffEntity selectstaffid(String idNumber);

	/**
	 * 人員基本情報取得。
	 * @param staffCd 従業員コード
     */
	public JIN0002StaffEntity selectstaff(Integer staffCd);

	/**
	 * 人員基本情報排他クエリーする。
	 * @param staffCd 従業員コード
	 * @param reckosnzituymdhms レコード更新実年月日時分秒
	 */
	public boolean selectstafftime(
			Integer staffCd, Timestamp reckosnzituymdhms);

	/**
	 * 人員基本情報削除する。
	 * @param staffCd 従業員コード
     */
	int delectstaff(Integer staffCd);

	/**
	 * 人員基本情報追加する。
	 * @param staffEntity 人員基本情報
     */
	public int insertStaff(JIN0002StaffEntity staffEntity);

	/**
	 * 人員基本情報变更する。
	 * @param staffEntity 人員基本情報
     */
	public int updatestaff(JIN0002StaffEntity staffEntity);


	/**
	 * 問合せ者の基本情報を自動的に補完する
	 * @author caichunyu
	 */
	List<JIN0002StaffEntity> selectJIN0002StaffEntitysByName(String name);
}
