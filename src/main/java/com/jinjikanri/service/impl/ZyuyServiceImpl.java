package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jinjikanri.entity.HKN0010ZyuyntsEntity;
import com.jinjikanri.mapper.ZyuyMapper;
import com.jinjikanri.service.ZyuyService;

/**
 * 
 * @author 史林林 2019/12/30
 */
@Service
public class ZyuyServiceImpl implements ZyuyService{

	@Autowired
	private ZyuyMapper zyuyMapper;

	/**
	 * 剰余日数と出勤時刻情報取得。
	 * @param sttCd 設定コード
     */
	@Override
	public HKN0010ZyuyntsEntity getZyuyById(Integer sttCd) {
		HKN0010ZyuyntsEntity getzyuy = this.zyuyMapper.getZyuyById(sttCd);
		if (getzyuy == null) {
			return null;
		}
		return zyuyMapper.getZyuyById(sttCd);
	}

	/**
	 * 剰余日数と出勤時刻情報变更する。
	 * @param zyuy 剰余日数と出勤時刻情報
     */
	@Override
	public void updateZyuyById(HKN0010ZyuyntsEntity zyuy) {
		zyuyMapper.updateZyuyById(zyuy);
	}

	/**
	 * 剰余日数と出勤時刻情報排他クエリーする
	 * @param sttCd 設定コード
	 * @param reckosnzituymdhms レコード更新実年月日時分秒
     */
	@Override
	public boolean selectDB(
			@RequestParam("sttCd") Integer sttCd,
			@RequestParam("Timestamp") Timestamp recKosnZituYmdHms) {
		HKN0010ZyuyntsEntity zyuyntsEntity = zyuyMapper.selectDB(sttCd, recKosnZituYmdHms);
		if (zyuyntsEntity != null) {
			return true;
		}
		return false;
//		return this.zyuyMapper.selectDB(sttCd, recKosnZituYmdHms);
	}

}
