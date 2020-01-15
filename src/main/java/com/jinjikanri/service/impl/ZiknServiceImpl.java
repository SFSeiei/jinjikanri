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

	/**
	 * 課税所得額から税率取得する
	 * @return ziknMapper.selectZiknById()
	 */
	@Override
	public HKN0009ZiknEntity selectZiknById() {
		return this.ziknMapper.selectZiknById();
	}

	/**
	 * 課税所得額から税率変更する
	 * @param zikn 課税所得額から税率
	 */
	@Override
	public void updateZiknById(HKN0009ZiknEntity zikn) {
		ziknMapper.updateZiknById(zikn);
	}

	/**
	 * 課税所得額から税率排他クエリーする
	 * @param recKosnZituYmdHms レコード更新実年月日時分秒
	 * @return ziknMapper.getZiknDBcheck(recKosnZituYmdHms)
	 */
	@Override
	public HKN0009ZiknEntity getZiknDBcheck(Timestamp recKosnZituYmdHms) {
		return ziknMapper.getZiknDBcheck(recKosnZituYmdHms);
	}
}
