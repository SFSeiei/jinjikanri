package com.jinjikanri.entity;

import java.sql.Timestamp;

/**
 * パラメータの設定<BR>
 * パラメータの設定各项目の内容一覧<BR>
 * @author 日立 史林林 2019/12/18
 */
public class HKN0010ZyuyntsEntity {

    /**
     * 設定コード。
     */
    private Integer sttCd;
	
    /**
     * 誕生日前倒し日数。
     */
    private Integer tnzybZynts;

    /**
     * 身分証期限前倒し日数。
     */
    private Integer mbnsyuZynts;

    /**
     * 健診日前倒し日数。
     */
    private Integer knsunZynts;

    /**
     * 昼間出勤開始時刻。
     */
    private Integer hrmkuKisi;

    /**
     * 昼間出勤終了時刻。
     */
    private Integer hrmkuSyryu;

    /**
     * 夜間出勤開始時刻。
     */
    private Integer yknkuKisi;
    
    /**
     * 夜間出勤終了時刻。
     */
    private Integer yknkuSyryu;
    
    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;

    /**
     * 設定コードを取得する。
     * @param なし
     * @return sttCd 設定コード
     * @exception なし
     */
    public Integer getSttCd() {
        return this.sttCd;
    }

    /**
     * 設定コードを設定する。
     * @param sttCd 設定コード
     * @return なし
     * @exception なし
     */
    public void setSttCd(Integer sttCd) {
        this.sttCd = sttCd;
    }
    
    /**
     * 誕生日前倒し日数を取得する。
     * @param なし
     * @return tnzybZynts 誕生日前倒し日数
     * @exception なし
     */
    public Integer getTnzybZynts() {
        return this.tnzybZynts;
    }

    /**
     * 誕生日前倒し日数を設定する。
     * @param tnzybZynts 誕生日前倒し日数
     * @return なし
     * @exception なし
     */
    public void setTnzybZynts(Integer tnzybZynts) {
        this.tnzybZynts = tnzybZynts;
    }

    /**
     * 身分証期限前倒し日数を取得する。
     * @param なし
     * @return mbnsyuZynts 身分証期限前倒し日数
     * @exception なし
     */
    public Integer getMbnsyuZynts() {
        return this.mbnsyuZynts;
    }

    /**
     * 身分証期限前倒し日数を設定する。
     * @param mbnsyuZynts 身分証期限前倒し日数
     * @return なし
     * @exception なし
     */
    public void setMbnsyuZynts(Integer mbnsyuZynts) {
        this.mbnsyuZynts = mbnsyuZynts;
    }

    /**
     * 健診日前倒し日数を取得する。
     * @param なし
     * @return knsunZynts 健診日前倒し日数
     * @exception なし
     */
    public Integer getKnsunZynts() {
        return this.knsunZynts;
    }

    /**
     * 健診日前倒し日数を設定する。
     * @param knsunZynts 健診日前倒し日数
     * @return なし
     * @exception なし
     */
    public void setKnsunZynts(Integer knsunZynts) {
        this.knsunZynts = knsunZynts;
    }

    /**
     * 昼間出勤開始時刻を取得する。
     * @param なし
     * @return hrmkuKisi 昼間出勤開始時刻
     * @exception なし
     */
    public Integer getHrmkuKisi() {
        return this.hrmkuKisi;
    }

    /**
     * 昼間出勤開始時刻を設定する。
     * @param hrmkuKisi 昼間出勤開始時刻
     * @return なし
     * @exception なし
     */
    public void setHrmkuKisi(Integer hrmkuKisi) {
        this.hrmkuKisi = hrmkuKisi;
    }

    /**
     * 昼間出勤終了時刻を取得する。
     * @param なし
     * @return hrmkuSyryu 昼間出勤終了時刻
     * @exception なし
     */
    public Integer getHrmkuSyryu() {
        return this.hrmkuSyryu;
    }

    /**
     * 昼間出勤終了時刻を設定する。
     * @param hrmkuSyryu 昼間出勤終了時刻
     * @return なし
     * @exception なし
     */
    public void setHrmkuSyryu(Integer hrmkuSyryu) {
        this.hrmkuSyryu = hrmkuSyryu;
    }

    /**
     * 夜間出勤開始時刻を取得する。
     * @param なし
     * @return yknkuKisi 夜間出勤開始時刻
     * @exception なし
     */
    public Integer getYknkuKisi() {
        return this.yknkuKisi;
    }

    /**
     * 夜間出勤開始時刻を設定する。
     * @param yknkuKisi 夜間出勤開始時刻
     * @return なし
     * @exception なし
     */
    public void setYknkuKisi(Integer yknkuKisi) {
        this.yknkuKisi = yknkuKisi;
    }
    
    /**
     * 夜間出勤終了時刻を取得する。
     * @param なし
     * @return yknkuSyryu 夜間出勤終了時刻
     * @exception なし
     */
    public Integer getYknkuSyryu() {
        return this.yknkuSyryu;
    }

    /**
     * 夜間出勤終了時刻を設定する。
     * @param yknkuSyryu 夜間出勤終了時刻
     * @return なし
     * @exception なし
     */
    public void setYknkuSyryu(Integer yknkuSyryu) {
        this.yknkuSyryu = yknkuSyryu;
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

}
