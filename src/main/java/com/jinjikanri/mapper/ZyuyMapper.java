package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jinjikanri.entity.HKN0010ZyuyntsEntity;

/**
 * DB操作<BR>
 * DB詳細操作の実行
 * @author 史林林　2019/12/27
 */
@Repository
@Mapper
public interface ZyuyMapper {
	
	/**
	 * 剰余日数と出勤時刻情報取得。
	 * @param sttCd 設定コード
     */
	HKN0010ZyuyntsEntity getZyuyById(Integer sttCd);
	
	/**
	 * 剰余日数と出勤時刻情報变更する。
	 * @param zyuy 剰余日数と出勤時刻情報
     */
	void updateZyuyById(HKN0010ZyuyntsEntity zyuy);
	
	/**
	 * 数据验证
	 * @param zyuy 剰余日数と出勤時刻情報
	 */
	List<HKN0010ZyuyntsEntity> dataValid(HKN0010ZyuyntsEntity zyuy);
	
	/**
	 * 剰余日数と出勤時刻情報变更する。
	 * @param sttCd 設定コード
	 * @param reckosnzituymdhms レコード更新実年月日時分秒
     */
	HKN0010ZyuyntsEntity selectDB(Integer sttCd, Timestamp recKosnZituYmdHms);

}
