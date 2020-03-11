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
 * <DD>2019/12/26 14:47 新規作成</DD>
 * </DL>
 * 
 * @author zhangxuping
 * @version （2019/12/26） 1.00
 */


public class SYST06RightEntity {

    /**
     * 権限コード。
     */
    private Integer rightCd;

    /**
     * 上?権限コード。
     */
    private Integer pRightCd;

    /**
     * 権限名。
     */
    private String rightMei;

    /**
     * 権限ディスクリプション。
     */
    private String rightDhiskrpsn;

    /**
     * 権限キー。
     */
    private String rightKey;

    /**
     * 権限URL。
     */
    private String rightUrl;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;


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
     * 上?権限コードを取得する。
     * @param なし
     * @return pRightCd 上?権限コード
     * @exception なし
     */
    public Integer getPRightCd() {
        return this.pRightCd;
    }

    /**
     * 上?権限コードを設定する。
     * @param pRightCd 上?権限コード
     * @return なし
     * @exception なし
     */
    public void setPRightCd(Integer pRightCd) {
        this.pRightCd = pRightCd;
    }

    /**
     * 権限名を取得する。
     * @param なし
     * @return rightMei 権限名
     * @exception なし
     */
    public String getRightMei() {
        return this.rightMei;
    }

    /**
     * 権限名を設定する。
     * @param rightMei 権限名
     * @return なし
     * @exception なし
     */
    public void setRightMei(String rightMei) {
        this.rightMei = rightMei;
    }

    /**
     * 権限ディスクリプションを取得する。
     * @param なし
     * @return rightDhiskrpsn 権限ディスクリプション
     * @exception なし
     */
    public String getRightDhiskrpsn() {
        return this.rightDhiskrpsn;
    }

    /**
     * 権限ディスクリプションを設定する。
     * @param rightDhiskrpsn 権限ディスクリプション
     * @return なし
     * @exception なし
     */
    public void setRightDhiskrpsn(String rightDhiskrpsn) {
        this.rightDhiskrpsn = rightDhiskrpsn;
    }

    /**
     * 権限キーを取得する。
     * @param なし
     * @return rightKey 権限キー
     * @exception なし
     */
    public String getRightKey() {
        return this.rightKey;
    }

    /**
     * 権限キーを設定する。
     * @param rightKey 権限キー
     * @return なし
     * @exception なし
     */
    public void setRightKey(String rightKey) {
        this.rightKey = rightKey;
    }

    /**
     * 権限URLを取得する。
     * @param なし
     * @return rightUrl 権限URL
     * @exception なし
     */
    public String getRightUrl() {
        return this.rightUrl;
    }

    /**
     * 権限URLを設定する。
     * @param rightUrl 権限URL
     * @return なし
     * @exception なし
     */
    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl;
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

        // 権限コード
        buffer.append(",rightCd=");
        buffer.append(this.rightCd);
        // 上?権限コード
        buffer.append(",pRightCd=");
        buffer.append(this.pRightCd);
        // 権限名
        buffer.append(",rightMei=");
        buffer.append(this.rightMei);
        // 権限ディスクリプション
        buffer.append(",rightDhiskrpsn=");
        buffer.append(this.rightDhiskrpsn);
        // 権限キー
        buffer.append(",rightKey=");
        buffer.append(this.rightKey);
        // 権限URL
        buffer.append(",rightUrl=");
        buffer.append(this.rightUrl);
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

        // 権限コード
        rightCd = null;
        // 上?権限コード
        pRightCd = null;
        // 権限名
        rightMei = null;
        // 権限ディスクリプション
        rightDhiskrpsn = null;
        // 権限キー
        rightKey = null;
        // 権限URL
        rightUrl = null;
        // レコード作成実年月日時分秒
        recSaksZituYmdHms = null;
        // レコード更新実年月日時分秒
        recKosnZituYmdHms = null;

        //super.release();
    }
}