package com.jinjikanri.service;

import java.sql.Timestamp;

import com.jinjikanri.entity.HKN0009ZiknEntity;

/**
 * “税金計算基準の設定”のサービス層インターフェース
 *@author 時煜程 2019/12/23
 */
public interface ZiknService {

	// 1データの検索
	HKN0009ZiknEntity selectZiknById();

	// 1データの変更
	void updateZiknById(HKN0009ZiknEntity zikn);

	// 1データの排他
	HKN0009ZiknEntity getZiknDBcheck(Timestamp recKosnZituYmdHms);
}
