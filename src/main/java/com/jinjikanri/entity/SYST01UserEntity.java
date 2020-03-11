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
 * <DD>2019/12/24 15:11 新規作成</DD>
 * </DL>
 * 
 * @author zhangxuping
 * @version （2019/12/24） 1.00
 */


public class SYST01UserEntity {

    /**
     * ユーザーコード。
     */
    private Integer usrCd;

    /**
     * ユーザーID。
     */
    private String usrId;

    /**
     * パスワード。
     */
    private String passwd;

    /**
     * 従業員コード。
     */
    private Integer staffCd;

    /**
     * ユーザーステータス。
     */
    private Integer usrSutts;

    /**
     * オンラインフラッグ。
     */
    private Integer onrinFurg;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;


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
     * ユーザーIDを取得する。
     * @param なし
     * @return usrId ユーザーID
     * @exception なし
     */
    public String getUsrId() {
        return this.usrId;
    }

    /**
     * ユーザーIDを設定する。
     * @param usrId ユーザーID
     * @return なし
     * @exception なし
     */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
     * パスワードを取得する。
     * @param なし
     * @return passwd パスワード
     * @exception なし
     */
    public String getPasswd() {
        return this.passwd;
    }

    /**
     * パスワードを設定する。
     * @param passwd パスワード
     * @return なし
     * @exception なし
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 従業員コードを取得する。
     * @param なし
     * @return staffCd 従業員コード
     * @exception なし
     */
    public Integer getStaffCd() {
        return this.staffCd;
    }

    /**
     * 従業員コードを設定する。
     * @param staffCd 従業員コード
     * @return なし
     * @exception なし
     */
    public void setStaffCd(Integer staffCd) {
        this.staffCd = staffCd;
    }

    /**
     * ユーザーステータスを取得する。
     * @param なし
     * @return usrSutts ユーザーステータス
     * @exception なし
     */
    public Integer getUsrSutts() {
        return this.usrSutts;
    }

    /**
     * ユーザーステータスを設定する。
     * @param usrSutts ユーザーステータス
     * @return なし
     * @exception なし
     */
    public void setUsrSutts(Integer usrSutts) {
        this.usrSutts = usrSutts;
    }

    /**
     * オンラインフラッグを取得する。
     * @param なし
     * @return onrinFurg オンラインフラッグ
     * @exception なし
     */
    public Integer getOnrinFurg() {
        return this.onrinFurg;
    }

    /**
     * オンラインフラッグを設定する。
     * @param onrinFurg オンラインフラッグ
     * @return なし
     * @exception なし
     */
    public void setOnrinFurg(Integer onrinFurg) {
        this.onrinFurg = onrinFurg;
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

        // ユーザーコード
        buffer.append(",usrCd=");
        buffer.append(this.usrCd);
        // ユーザーID
        buffer.append(",usrId=");
        buffer.append(this.usrId);
        // パスワード
        buffer.append(",passwd=");
        buffer.append(this.passwd);
        // 従業員コード
        buffer.append(",staffCd=");
        buffer.append(this.staffCd);
        // ユーザーステータス
        buffer.append(",usrSutts=");
        buffer.append(this.usrSutts);
        // オンラインフラッグ
        buffer.append(",onrinFurg=");
        buffer.append(this.onrinFurg);
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

        // ユーザーコード
        usrCd = null;
        // ユーザーID
        usrId = null;
        // パスワード
        passwd = null;
        // 従業員コード
        staffCd = null;
        // ユーザーステータス
        usrSutts = null;
        // オンラインフラッグ
        onrinFurg = null;
        // レコード作成実年月日時分秒
        recSaksZituYmdHms = null;
        // レコード更新実年月日時分秒
        recKosnZituYmdHms = null;

        //super.release();
    }
}