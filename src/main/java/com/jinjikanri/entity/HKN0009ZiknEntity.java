package com.jinjikanri.entity;

import java.sql.Timestamp;
/**
 * 税金計算基準の設定 
 * エンティティのデータクラスを持つ
 * @author 時煜程　2019/12/18
 */
public class HKN0009ZiknEntity {

    /**
      * 税金コード。
      */
    private Integer ziknCd;
	/**
	  * 課税所得額等級１
	  */
	private Integer tukiTinkinTkyu1;
	/**
	  * 課税所得額等級２
	  */
	private Integer tukiTinkinTkyu2;
	/**
	  * 課税所得額等級３
	  */
	private Integer tukiTinkinTkyu3;
	/**
	  * 課税所得額等級４
	  */
	private Integer tukiTinkinTkyu4;
	/**
	  * 課税所得額等級５
	  */
	private Integer tukiTinkinTkyu5;
	/**
	  * 課税所得額等級６
	  */
	private Integer tukiTinkinTkyu6;
	/**
	  * 課税所得額等級７
	  */
	private Integer tukiTinkinTkyu7;
	/**
	  * 税率区分１
	  */
	private Integer zeiritKbn1;
	/**
	  * 税率区分２
	  */
	private Integer zeiritKbn2;
	/**
	  * 税率区分３
	  */
	private Integer zeiritKbn3;
	/**
	  * 税率区分４
	  */
	private Integer zeiritKbn4;
	/**
	  * 税率区分５
	  */
	private Integer zeiritKbn5;
	/**
	  * 税率区分６
	  */
	private Integer zeiritKbn6;
	/**
	  * 税率区分７
	  */
	private Integer zeiritKbn7;
    /**
      * レコード作成実年月日時分秒。
      */
    private Timestamp recSaksZituYmdHms;
    /**
      * レコード更新実年月日時分秒。
      */
    private Timestamp recKosnZituYmdHms;
    /**
      * 税金コードを取得する。
      * @param なし
      * @return ziknCd 税金コード
      * @exception なし
      */
    public Integer getZiknCd() {
        return this.ziknCd;
    }

    /**
      *　税金コードを設定する。
      * @param ziknCd 税金コード
      * @return なし
      * @exception なし
      */
    public void setZiknCd(Integer ziknCd) {
        this.ziknCd = ziknCd;
    }

	/** 
	  * 課税所得額等級１を取得する
      * @param なし
      * @return tukiTinkinTkyu1 課税所得額等級１
      * @exception なし
      */
    public Integer getTukiTinkinTkyu1() {
        return this.tukiTinkinTkyu1;
    }

    /**
      * 課税所得額等級１を設定する
      * @param tukiTinkinTkyu1 課税所得額等級１
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu1(Integer tukiTinkinTkyu1) {
        this.tukiTinkinTkyu1 = tukiTinkinTkyu1;
    }

	/**
	  * 課税所得額等級2を取得する
      * @param なし
      * @return tukiTinkinTkyu2 課税所得額等級2
      * @exception なし
      */
    public Integer getTukiTinkinTkyu2() {
        return this.tukiTinkinTkyu2;
    }

    /**
      * 課税所得額等級2を設定する
      * @param tukiTinkinTkyu2 課税所得額等級2
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu2(Integer tukiTinkinTkyu2) {
        this.tukiTinkinTkyu2 = tukiTinkinTkyu2;
    }

	/**
	  * 課税所得額等級3を取得する
	  * @param なし
      * @return tukiTinkinTkyu3 課税所得額等級3
      * @exception なし
      */
    public Integer getTukiTinkinTkyu3() {
        return this.tukiTinkinTkyu3;
    }

    /**
      * 課税所得額等級3を設定する
      * @param tukiTinkinTkyu3 課税所得額等級3
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu3(Integer tukiTinkinTkyu3) {
        this.tukiTinkinTkyu3 = tukiTinkinTkyu3;
    }

	/**
	  * 課税所得額等級4を取得する
      * @param なし
      * @return tukiTinkinTkyu4 課税所得額等級4
      * @exception なし
      */
    public Integer getTukiTinkinTkyu4() {
        return this.tukiTinkinTkyu4;
    }

    /**
      * 課税所得額等級4を設定する
      * @param tukiTinkinTkyu4 課税所得額等級4
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu4(Integer tukiTinkinTkyu4) {
        this.tukiTinkinTkyu4 = tukiTinkinTkyu4;
    }

	/** 
	  * 課税所得額等級5を取得する
      * @param なし
      * @return tukiTinkinTkyu5 課税所得額等級5
      * @exception なし
      */
    public Integer getTukiTinkinTkyu5() {
        return this.tukiTinkinTkyu5;
    }

    /**
      * 課税所得額等級5を設定する
      * @param tukiTinkinTkyu5 課税所得額等級5
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu5(Integer tukiTinkinTkyu5) {
        this.tukiTinkinTkyu5 = tukiTinkinTkyu5;
    }

	/** 
	  * 課税所得額等級6を取得する
      * @param なし
      * @return tukiTinkinTkyu6 課税所得額等級6
      * @exception なし
      */
    public Integer getTukiTinkinTkyu6() {
        return this.tukiTinkinTkyu6;
    }

    /**
      * 課税所得額等級6を設定する
      * @param tukiTinkinTkyu6 課税所得額等級6
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu6(Integer tukiTinkinTkyu6) {
        this.tukiTinkinTkyu6 = tukiTinkinTkyu6;
    }

	/** 
	  * 課税所得額等級7を取得する
      * @param なし
      * @return tukiTinkinTkyu7 課税所得額等級7
      * @exception なし
      */
    public Integer getTukiTinkinTkyu7() {
        return this.tukiTinkinTkyu7;
    }

    /**
      * 課税所得額等級7を設定する
      * @param tukiTinkinTkyu7 課税所得額等級7
      * @return なし
      * @exception なし
      */
    public void setTukiTinkinTkyu7(Integer tukiTinkinTkyu7) {
        this.tukiTinkinTkyu7 = tukiTinkinTkyu7;
    }

    /**
      * 税率区分１ を取得する
      * @param なし
      * @return zeiritKbn1 税率区分１
      * @exception なし
      */
    public Integer getZeiritKbn1() {
        return this.zeiritKbn1;
    }

    /**
      * 税率区分１を設定する
      * @param zeiritKbn1 税率区分１
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn1(Integer zeiritKbn1) {
        this.zeiritKbn1 = zeiritKbn1;
    }

    /**
      * 税率区分2 を取得する
      * @param なし
      * @return zeiritKbn2 税率区分2
      * @exception なし
      */
    public Integer getZeiritKbn2() {
        return this.zeiritKbn2;
    }

    /**
      * 税率区分2を設定する
      * @param zeiritKbn2 税率区分2
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn2(Integer zeiritKbn2) {
        this.zeiritKbn2 = zeiritKbn2;
    }

    /**
      * 税率区分3 を取得する
      * @param なし
      * @return zeiritKbn3 税率区分3
      * @exception なし
      */
    public Integer getZeiritKbn3() {
        return this.zeiritKbn3;
    }

    /**
      * 税率区分3を設定する
      * @param zeiritKbn3 税率区分3
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn3(Integer zeiritKbn3) {
        this.zeiritKbn3 = zeiritKbn3;
    }

    /**
      * 税率区分4を取得する
      * @param なし
      * @return zeiritKbn4 税率区分4
      * @exception なし
      */
    public Integer getZeiritKbn4() {
        return this.zeiritKbn4;
    }

    /**
      * 税率区分4を設定する
      * @param zeiritKbn4 税率区分4
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn4(Integer zeiritKbn4) {
        this.zeiritKbn4 = zeiritKbn4;
    }

    /**
      * 税率区分5を取得する
      * @param なし
      * @return zeiritKbn5 税率区分5
      * @exception なし
      */
    public Integer getZeiritKbn5() {
        return this.zeiritKbn5;
    }

    /**
      * 税率区分5を設定する
      * @param zeiritKbn5 税率区分5
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn5(Integer zeiritKbn5) {
        this.zeiritKbn5 = zeiritKbn5;
    }

    /**
      * 税率区分6を取得する
      * @param なし
      * @return zeiritKbn6 税率区分6
      * @exception なし
      */
    public Integer getZeiritKbn6() {
        return this.zeiritKbn6;
    }

    /**
      * 税率区分6を設定する
      * @param zeiritKbn6 税率区分6
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn6(Integer zeiritKbn6) {
        this.zeiritKbn6 = zeiritKbn6;
    }

    /**
      * 税率区分7を取得する
      * @param なし
      * @return zeiritKbn7 税率区分7
      * @exception なし
      */
    public Integer getZeiritKbn7() {
        return this.zeiritKbn7;
    }

    /**
      * 税率区分7を設定する
      * @param zeiritKbn7 税率区分7
      * @return なし
      * @exception なし
      */
    public void setZeiritKbn7(Integer zeiritKbn7) {
        this.zeiritKbn7 = zeiritKbn7;
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
