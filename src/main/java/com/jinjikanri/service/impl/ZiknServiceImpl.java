package com.jinjikanri.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinjikanri.entity.HKN0009ZiknEntity;
import com.jinjikanri.mapper.ZiknMapper;
import com.jinjikanri.service.ZiknService;

/**
 * “税金計算基準の設定”のサービス層インターフェースの実現類
 *@author 時煜程 2019/12/23
 */
@Service
public class ZiknServiceImpl implements ZiknService {

	@Autowired
	private ZiknMapper ziknMapper;

	// 1データの検索
	@Override
	public HKN0009ZiknEntity selectZiknById() {
		return this.ziknMapper.selectZiknById();
	}

	// 1データの変更
	@Override
	public void updateZiknById(HKN0009ZiknEntity zikn) {
		ziknMapper.updateZiknById(zikn);
	}

	// 1データの排他
	@Override
	public HKN0009ZiknEntity getZiknDBcheck(Timestamp recKosnZituYmdHms) {
		return ziknMapper.getZiknDBcheck(recKosnZituYmdHms);
	}
}
