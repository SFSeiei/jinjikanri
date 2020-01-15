package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinjikanri.entity.HKN0007KnsunEntity;

/**
 * DB操作<BR>
 * DB詳細操作の実行
 * @author 李春菊  2019/12/27
 *
 */
@Mapper
public interface HKN0007KnsunMapper {
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
	List<HKN0007KnsunEntity> selectKnsun(List<Integer> knsunIdList);
	/**
	 * 新規追加の方法
	 * @param knsun
	 * @return
	 */
	int insertKnsun(HKN0007KnsunEntity knsun);
	/**
	 * IDにより健診日情報を取得する
	 * @param knsunId
	 * @return
	 */
	HKN0007KnsunEntity getKnsunById(Integer knsunId);
	/**
	 * 排他
	 * @param knsunId
	 * @param recKosnZituYmdHms
	 * @return
	 */
	HKN0007KnsunEntity getKnsunByIdAndUpdateTime(@Param("knsunId") Integer knsunId, @Param("recKosnZituYmdHms") Timestamp recKosnZituYmdHms);
	/**
	 * 削除の方法
	 * @param knsunId
	 * @return
	 */
	int deleteKnsun(Integer knsunId);
	/**
	 * 変更の方法
	 * @param knsun
	 * @return
	 */
	int updateKnsunById(HKN0007KnsunEntity knsun);
	/**
	 * 数据验证
	 * @author lichunju
	 * @param knsun
	 * @return
	 */
	List<HKN0007KnsunEntity> dataValid(HKN0007KnsunEntity knsun);
}
