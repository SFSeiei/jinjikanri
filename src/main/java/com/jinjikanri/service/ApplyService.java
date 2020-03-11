package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.Map;

import com.jinjikanri.entity.JIN0003QbbgEntity;

public interface ApplyService {
	/*データの追加*/
	public int addApplyInfor(JIN0003QbbgEntity apply);
	/*申請データの検索*/
	public Map<String, Object> getApplyList(JIN0003QbbgEntity apply,int offset);
	/*履歴データの検索*/
	public Map<String, Object> getApplyHistory(JIN0003QbbgEntity apply,int offset);
	/*指定IDデータの削除*/
	public int delDate(Integer dateId);
	/*指定IDデータの更新*/
	public int updateApply(JIN0003QbbgEntity apply);
	/*指定IDデータの検索*/
	public JIN0003QbbgEntity selApplyById(Integer dateId);
	/*指定IDと更新日時データの削除*/
	public JIN0003QbbgEntity getDataByIdTime(Integer dateId,Timestamp recKosnZituYmdHms);
	
}
