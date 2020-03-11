package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;


import com.jinjikanri.entity.JIN0003QbbgEntity;

@Mapper
public interface ApplyMapper {
	/*データの追加*/
	int addApplyInfor(JIN0003QbbgEntity apply);
	/*申請データの検索*/
	List<JIN0003QbbgEntity> getApplyList(JIN0003QbbgEntity apply, RowBounds rowBounds);
	/*履歴データの検索*/
	List<JIN0003QbbgEntity> getApplyHistory(JIN0003QbbgEntity apply, RowBounds rowBounds);
	/*指定IDデータの削除*/
	int delDate(Integer dateId);
	/*指定IDデータの更新*/
	int updateApply(JIN0003QbbgEntity apply);
	/*指定IDデータの検索*/
	JIN0003QbbgEntity selApplyById(Integer dateId); 
	/*指定IDと更新日時データの削除*/
	JIN0003QbbgEntity getDataByIdTime(Integer dateId,Timestamp recKosnZituYmdHms); 
	
}
