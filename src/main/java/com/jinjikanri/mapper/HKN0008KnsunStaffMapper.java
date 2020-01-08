package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.HKN0008KnsunStaffEntity;

@Mapper
public interface HKN0008KnsunStaffMapper {
	
	List<HKN0008KnsunStaffEntity> hkn0008KnsunStaffEntities(HKN0008KnsunStaffEntity hkn0008KnsunStaffEntity, RowBounds rowBounds);
	/**
	 * 新規追加の方法
	 * @param knsunStaff
	 * @return
	 */
	int insertKnsunStaff(HKN0008KnsunStaffEntity knsunStaff);
	/**
	 * IDにより健診日情報を取得する
	 * @param knsunStaffId
	 * @return
	 */
	HKN0008KnsunStaffEntity getKnsunStaffById(Integer knsunStaffId);
	/**
	 * 排他
	 * @param knsunStaffId
	 * @param recKosnZituYmdHms
	 * @return
	 */
	HKN0008KnsunStaffEntity getKnsunStaffByIdAndUpdateTime(@Param("knsunStaffId") Integer knsunStaffId, @Param("recKosnZituYmdHms") Timestamp recKosnZituYmdHms);
	/**
	 * 削除の方法
	 * @param id
	 * @return
	 */
	int deleteKnsunStaffById(Integer id);
	/**
	 * 変更の方法
	 * @param knsunStaff
	 * @return
	 */
	int updateknsunStaffById(HKN0008KnsunStaffEntity knsunStaff);
	
	/**
	 * 数据验证
	 * @author lichunju
	 * @param knsunStaff
	 * @return
	 */
	List<HKN0008KnsunStaffEntity> dataValid(HKN0008KnsunStaffEntity knsunStaff);
	
}
