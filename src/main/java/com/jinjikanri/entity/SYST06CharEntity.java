package com.jinjikanri.entity;

import java.sql.Timestamp;

/**
 * データクラス
 * 
 * <DL>
 * <DT><B>著作権:</B></DT>
 * <DD>Copyright(C) 2011 by SUMISHO COMPUTER SYSTEMS CORP.</DD>
 * <DD>3-2-20, Toyosu, Koutou-ku,</DD>
 * <DD>Tokyo 135-8110 JAPAN</DD>
 * <DT><B>改正履歴:</B></DT>
 * <DD>2019/12/19 14:25 新規作成</DD>
 * </DL>
 * 
 * @author zhangxuping
 * @version （2019/12/19） 1.00
 */

public class SYST06CharEntity {

	/**
	 * キャラクターコード。
	 */
	private Integer charCd;

	/**
	 * キャラクター名。
	 */
	private String charMei;

	/**
	 * キャラクターディスクリプション。
	 */
	private String charDhiskrpsn;

	/**
	 * レコード作成実年月日時分秒。
	 */
	private Timestamp recSaksZituYmdHms;

	/**
	 * レコード更新実年月日時分秒。
	 */
	private Timestamp recKosnZituYmdHms;
	
	/**
	 * キャラクターコードを取得する。
	 * 
	 * @param なし
	 * @return charCd キャラクターコード
	 * @exception なし
	 */
	public Integer getCharCd() {
		return this.charCd;
	}

	/**
	 * キャラクターコードを設定する。
	 * 
	 * @param charCd キャラクターコード
	 * @return なし
	 * @exception なし
	 */
	public void setCharCd(Integer charCd) {
		this.charCd = charCd;
	}

	/**
	 * キャラクター名を取得する。
	 * 
	 * @param なし
	 * @return charMei キャラクター名
	 * @exception なし
	 */
	public String getCharMei() {
		return this.charMei;
	}

	/**
	 * キャラクター名を設定する。
	 * 
	 * @param charMei キャラクター名
	 * @return なし
	 * @exception なし
	 */
	public void setCharMei(String charMei) {
		this.charMei = charMei;
	}

	/**
	 * キャラクターディスクリプションを取得する。
	 * 
	 * @param なし
	 * @return charDhiskrpsn キャラクターディスクリプション
	 * @exception なし
	 */
	public String getCharDhiskrpsn() {
		return this.charDhiskrpsn;
	}

	/**
	 * キャラクターディスクリプションを設定する。
	 * 
	 * @param charDhiskrpsn キャラクターディスクリプション
	 * @return なし
	 * @exception なし
	 */
	public void setCharDhiskrpsn(String charDhiskrpsn) {
		this.charDhiskrpsn = charDhiskrpsn;
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

	/**
	 * ジャーナル取得用文字列の編集を行う。<BR>
	 * ①"項目ID=値,"の形式で編集<BR>
	 * ②対象項目は、全入力・入出力項目、持回情報
	 * 
	 * @param なし
	 * @return ジャーナル取得用文字列
	 * @exception なし
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer(super.toString());

		// キャラクターコード
		buffer.append(",charCd=");
		buffer.append(this.charCd);
		// キャラクター名
		buffer.append(",charMei=");
		buffer.append(this.charMei);
		// キャラクターディスクリプション
		buffer.append(",charDhiskrpsn=");
		buffer.append(this.charDhiskrpsn);
		// レコード作成実年月日時分秒
		buffer.append(",recSaksZituYmdHms=");
		buffer.append(this.recSaksZituYmdHms);
		// レコード更新実年月日時分秒
		buffer.append(",recKosnZituYmdHms=");
		buffer.append(this.recKosnZituYmdHms);

		return buffer.toString();
	}

	/**
	 * インスタンスを開放する。
	 * 
	 * @param なし
	 * @return なし
	 * @exception なし
	 */
	public void release() {

		// キャラクターコード
		charCd = null;
		// キャラクター名
		charMei = null;
		// キャラクターディスクリプション
		charDhiskrpsn = null;
		// レコード作成実年月日時分秒
		recSaksZituYmdHms = null;
		// レコード更新実年月日時分秒
		recKosnZituYmdHms = null;

		// super.release();
	}
}
