package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.Map;

import com.jinjikanri.entity.HKN0008KnsunStaffEntity;

public interface HKN0008KnsunStaffService {
	
	Map<String, Object> selectKnsunStaffs(HKN0008KnsunStaffEntity hkn0008KnsunStaffEntity, int offset);
	/**
	 * 新規追加の方法
	 * @param knsunStaff
	 * @return
	 */
	public int insertKnsunStaff(HKN0008KnsunStaffEntity knsunStaff);
	/**
	 * IDにより健診日情報を取得する
	 * @param knsunStaffId
	 * @return
	 */
	public HKN0008KnsunStaffEntity getKnsunStaffById(Integer knsunStaffId);
	/**
	 *  排他
	 * @param knsunStaffId
	 * @param recKosnZituYmdHms
	 * @return
	 */
	public HKN0008KnsunStaffEntity getKnsunStaffByIdAndUpdateTime(Integer knsunStaffId,Timestamp recKosnZituYmdHms);
	/**
	 * 削除の方法
	 * @param id
	 * @return
	 */
	public int deleteKnsunStaffById(Integer id);
	/**
	 * 変更の方法
	 * @param knsunStaff
	 * @return
	 */
	public int updateknsunStaffById(HKN0008KnsunStaffEntity knsunStaff);
}
