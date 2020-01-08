package com.jinjikanri.entity;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * パラメータの設定<BR>
 * パラメータの設定各项目の内容一覧<BR>
 * 
 * @author 日立 李春菊 2019/12/18
 */
public class HKN0007KnsunEntity {

	/**
	 * 健診日ID。
	 */
	private Integer knsunYmdId;

	/**
	 * 健診日開始。
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date knsunYmdStart;

	/**
	 * 健診日終了。
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date knsunYmdEnd;

	/**
	 * レコード作成実年月日時分秒。
	 */
	private Timestamp recSaksZituYmdHms;

	/**
	 * レコード更新実年月日時分秒。
	 */
	private Timestamp recKosnZituYmdHms;

	/**
	 * 健診日IDを取得する。
	 * 
	 * @param なし
	 * @return knsunYmdId 健診日ID
	 * @exception なし
	 */
	public Integer getKnsunYmdId() {
		return this.knsunYmdId;
	}

	/**
	 * 健診日IDを設定する。
	 * 
	 * @param knsunYmdId 健診日ID
	 * @return なし
	 * @exception なし
	 */
	public void setKnsunYmdId(Integer knsunYmdId) {
		this.knsunYmdId = knsunYmdId;
	}

	/**
	 * 健診日開始を取得する。
	 * 
	 * @param なし
	 * @return knsunYmdStart 健診日開始
	 * @exception なし
	 */
	public Date getKnsunYmdStart() {
		return this.knsunYmdStart;
	}

	/**
	 * 健診日開始を設定する。
	 * 
	 * @param knsunYmdStart 健診日開始
	 * @return なし
	 * @exception なし
	 */
	public void setKnsunYmdStart(Date knsunYmdStart) {
		this.knsunYmdStart = knsunYmdStart;
	}

	/**
	 * 健診日終了を取得する。
	 * 
	 * @param なし
	 * @return knsunYmdEnd 健診日終了
	 * @exception なし
	 */
	public Date getKnsunYmdEnd() {
		return this.knsunYmdEnd;
	}

	/**
	 * 健診日終了を設定する。
	 * 
	 * @param knsunYmdEnd 健診日終了
	 * @return なし
	 * @exception なし
	 */
	public void setKnsunYmdEnd(Date knsunYmdEnd) {
		this.knsunYmdEnd = knsunYmdEnd;
	}

	/**
	 * レコード作成実年月日時分秒を取得する。
	 * 
	 * @param なし
	 * @return recSaksZituYmdHms レコード作成実年月日時分秒
	 * @exception なし
	 */
	public Timestamp getRecSaksZituYmdHms() {
		return this.recSaksZituYmdHms;
	}

	/**
	 * レコード作成実年月日時分秒を設定する。
	 * 
	 * @param recSaksZituYmdHms レコード作成実年月日時分秒
	 * @return なし
	 * @exception なし
	 */
	public void setRecSaksZituYmdHms(Timestamp recSaksZituYmdHms) {
		this.recSaksZituYmdHms = recSaksZituYmdHms;
	}

	/**
	 * レコード更新実年月日時分秒を取得する。
	 * 
	 * @param なし
	 * @return recKosnZituYmdHms レコード更新実年月日時分秒
	 * @exception なし
	 */
	public Timestamp getRecKosnZituYmdHms() {
		return this.recKosnZituYmdHms;
	}

	/**
	 * レコード更新実年月日時分秒を設定する。
	 * 
	 * @param recKosnZituYmdHms レコード更新実年月日時分秒
	 * @return なし
	 * @exception なし
	 */
	public void setRecKosnZituYmdHms(Timestamp recKosnZituYmdHms) {
		this.recKosnZituYmdHms = recKosnZituYmdHms;
	}

}