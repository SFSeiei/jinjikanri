package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.JIN0002StaffEntity;

/**
 * DB操作<BR>
 * DB詳細操作の実行
 * @author 陳俊霖　2019/12/27
 */
@Mapper
public interface StaffMapper {

	/**
	 * 人員基本情報取得。
	 * @param idNumber 証件番号
     */
	JIN0002StaffEntity selectstaffid(String idNumber);

	/**
	 * 人員基本情報取得。
	 * @param staffCd 従業員コード
     */
	JIN0002StaffEntity selectstaff(Integer staffCd);

	/**
	 * 人員基本情報追加する。
	 * @param staffEntity 人員基本情報
     */
	int insertStaff(JIN0002StaffEntity staffEntity);

	/**
	 * 人員基本情報取得。
	 * @param staffEntity 人員基本情報
	 * @param rowBounds
	 */
	List<JIN0002StaffEntity> selectStaffs(
			JIN0002StaffEntity staffEntity, RowBounds rowBounds);

	/**
	 * 人員基本情報取得。
	 * @param staffCd 従業員コード
	 * @param reckosnzituymdhms レコード更新実年月日時分秒
	 */
	public JIN0002StaffEntity selectstafftime(
			Integer staffCd, Timestamp reckosnzituymdhms);

	/**
	 * 人員基本情報变更する。
	 * @param staffEntity 人員基本情報
     */
	int updatestaff(JIN0002StaffEntity staffEntity);

	/**
	 * 人員基本情報削除する。
	 * @param staffCd 従業員コード
     */
	int delestaff(Integer staffCd);

	/**
	 * 問合せ者の基本情報を自動的に補完する
	 * @author caichunyu
	 */
	List<JIN0002StaffEntity> selectJIN0002StaffEntitysByName(@Param("name") String name);
}
