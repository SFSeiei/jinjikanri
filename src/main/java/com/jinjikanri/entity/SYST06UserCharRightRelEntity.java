package com.jinjikanri.entity;

import java.sql.Timestamp;

/** 
 * データクラス
 * 
 * <DL>
 * <DT><B>著作権:</B></DT>
 * <DD>Copyright(C) 2011 by SUMISHO COMPUTER SYSTEMS CORP.</DD>
 * <DD>3-2-20, Toyosu, Koutou-ku, </DD>
 * <DD>Tokyo 135-8110 JAPAN </DD>
 * <DT><B>改正履歴:</B></DT>
 * <DD>2019/12/24 18:17 新規作成</DD>
 * </DL>
 * 
 * @author zhangxuping
 * @version （2019/12/24） 1.00
 */


public class SYST06UserCharRightRelEntity {

    /**
     * ユーザー_キャラクター_権限関係コード。
     */
    private Integer userCharRightCd;

    /**
     * ユーザー_キャラクター_権限関係名。
     */
    private String userCharRightMei;

    /**
     * ユーザーコード。
     */
    private Integer usrCd;

    /**
     * キャラクターコード。
     */
    private Integer charCd;

    /**
     * 権限コード。
     */
    private Integer rightCd;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;


    /**
     * ユーザー_キャラクター_権限関係コードを取得する。
     * @param なし
     * @return userCharRightCd ユーザー_キャラクター_権限関係コード
     * @exception なし
     */
    public Integer getUserCharRightCd() {
        return this.userCharRightCd;
    }

    /**
     * ユーザー_キャラクター_権限関係コードを設定する。
     * @param userCharRightCd ユーザー_キャラクター_権限関係コード
     * @return なし
     * @exception なし
     */
    public void setUserCharRightCd(Integer userCharRightCd) {
        this.userCharRightCd = userCharRightCd;
    }

    /**
     * ユーザー_キャラクター_権限関係名を取得する。
     * @param なし
     * @return userCharRightMei ユーザー_キャラクター_権限関係名
     * @exception なし
     */
    public String getUserCharRightMei() {
        return this.userCharRightMei;
    }

    /**
     * ユーザー_キャラクター_権限関係名を設定する。
     * @param userCharRightMei ユーザー_キャラクター_権限関係名
     * @return なし
     * @exception なし
     */
    public void setUserCharRightMei(String userCharRightMei) {
        this.userCharRightMei = userCharRightMei;
    }

    /**
     * ユーザーコードを取得する。
     * @param なし
     * @return usrCd ユーザーコード
     * @exception なし
     */
    public Integer getUsrCd() {
        return this.usrCd;
    }

    /**
     * ユーザーコードを設定する。
     * @param usrCd ユーザーコード
     * @return なし
     * @exception なし
     */
    public void setUsrCd(Integer usrCd) {
        this.usrCd = usrCd;
    }

    /**
     * キャラクターコードを取得する。
     * @param なし
     * @return charCd キャラクターコード
     * @exception なし
     */
    public Integer getCharCd() {
        return this.charCd;
    }

    /**
     * キャラクターコードを設定する。
     * @param charCd キャラクターコード
     * @return なし
     * @exception なし
     */
    public void setCharCd(Integer charCd) {
        this.charCd = charCd;
    }

    /**
     * 権限コードを取得する。
     * @param なし
     * @return rightCd 権限コード
     * @exception なし
     */
    public Integer getRightCd() {
        return this.rightCd;
    }

    /**
     * 権限コードを設定する。
     * @param rightCd 権限コード
     * @return なし
     * @exception なし
     */
    public void setRightCd(Integer rightCd) {
        this.rightCd = rightCd;
    }

    /**
     * レコード作成実年月日時分秒を取得する。
     * @param なし
     * @return recSaksZituYmdHms レコード作成実年月日時分秒
     * @exception なし
     */
    public Timestamp getRecSaksZituYmdHms() {
        return this.recSaksZituYmdHms;
    }

    /**
     * レコード作成実年月日時分秒を設定する。
     * @param recSaksZituYmdHms レコード作成実年月日時分秒
     * @return なし
     * @exception なし
     */
    public void setRecSaksZituYmdHms(Timestamp recSaksZituYmdHms) {
        this.recSaksZituYmdHms = recSaksZituYmdHms;
    }

    /**
     * レコード更新実年月日時分秒を取得する。
     * @param なし
     * @return recKosnZituYmdHms レコード更新実年月日時分秒
     * @exception なし
     */
    public Timestamp getRecKosnZituYmdHms() {
        return this.recKosnZituYmdHms;
    }

    /**
     * レコード更新実年月日時分秒を設定する。
     * @param recKosnZituYmdHms レコード更新実年月日時分秒
     * @return なし
     * @exception なし
     */
    public void setRecKosnZituYmdHms(Timestamp recKosnZituYmdHms) {
        this.recKosnZituYmdHms = recKosnZituYmdHms;
    }


    /**
     * ジャーナル取得用文字列の編集を行う。<BR>
     *   ①"項目ID=値,"の形式で編集<BR>
     *   ②対象項目は、全入力・入出力項目、持回情報
     * @param なし
     * @return ジャーナル取得用文字列
     * @exception なし
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer(super.toString());

        // ユーザー_キャラクター_権限関係コード
        buffer.append(",userCharRightCd=");
        buffer.append(this.userCharRightCd);
        // ユーザー_キャラクター_権限関係名
        buffer.append(",userCharRightMei=");
        buffer.append(this.userCharRightMei);
        // ユーザーコード
        buffer.append(",usrCd=");
        buffer.append(this.usrCd);
        // キャラクターコード
        buffer.append(",charCd=");
        buffer.append(this.charCd);
        // 権限コード
        buffer.append(",rightCd=");
        buffer.append(this.rightCd);
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
     * @param なし
     * @return なし
     * @exception なし
     */
    public void release() {

        // ユーザー_キャラクター_権限関係コード
        userCharRightCd = null;
        // ユーザー_キャラクター_権限関係名
        userCharRightMei = null;
        // ユーザーコード
        usrCd = null;
        // キャラクターコード
        charCd = null;
        // 権限コード
        rightCd = null;
        // レコード作成実年月日時分秒
        recSaksZituYmdHms = null;
        // レコード更新実年月日時分秒
        recKosnZituYmdHms = null;

        //super.release();
    }
}