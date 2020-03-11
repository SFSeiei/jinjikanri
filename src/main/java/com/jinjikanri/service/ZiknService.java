package com.jinjikanri.service;

import java.sql.Timestamp;

import com.jinjikanri.entity.HKN0009ZiknEntity;

/**
 * “税金計算基準の設定”のサービス層インターフェース
 *@author 時煜程 2019/12/23
 */
public interface ZiknService {

	/**
	 * 課税所得額から税率取得する
	 * @return
	 */
	HKN0009ZiknEntity selectZiknById();

	/**
	 * 課税所得額から税率変更する
	 * @param zikn 課税所得額から税率
	 */
	void updateZiknById(HKN0009ZiknEntity zikn);

	/**
	 * 課税所得額から税率排他クエリーする
	 * @param recKosnZituYmdHms レコード更新実年月日時分秒
	 * @return
	 */
	HKN0009ZiknEntity getZiknDBcheck(Timestamp recKosnZituYmdHms);
}