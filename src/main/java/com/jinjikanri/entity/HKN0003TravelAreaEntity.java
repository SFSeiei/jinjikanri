package com.jinjikanri.entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;

public class HKN0003TravelAreaEntity {
	
	 /**
     * 出張地域ID。
     */
    private Integer travelAreaId = null;

    /**
     * 地域省名称。
     */
    private String provinceName = null;

    /**
     * 地域市名称。
     */
    private String cityName = null;

    /**
     * 地域区/?名称。
     */
    private String countryName = null;

    /**
     * 補助金(BigDecimal)。
     */
    private BigDecimal travelMoney = null;

    /**
     * レコード作成実年月日時分秒。
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp recSaksZituYmdHms = null;

    /**
     * レコード更新実年月日時分秒（Timestamp）。
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp recKosnZituYmdHms = null;
    
    /**
     * 地域省ID。
     */
    private Integer provinceId;
    
    /**
     * 地域市ID。
     */
    private Integer cityId;
	 /**
     * 補助金(String)。
     */
	private String travelMoneyStr;
	  /**
     * レコード更新実年月日時分秒(String)。
     */
	private String recKosnZituYmdHmsStr;

    /**
     * 出張地域IDを取得する。
     * @param なし
     * @return travelAreaId 出張地域ID
     * @exception なし
     */
    public Integer getTravelAreaId() {
        return this.travelAreaId;
    }

    /**
     * 出張地域IDを設定する。
     * @param travelAreaId 出張地域ID
     * @return なし
     * @exception なし
     */
    public void setTravelAreaId(Integer travelAreaId) {
        this.travelAreaId = travelAreaId;
    }

    /**
     * 地域省名称を取得する。
     * @param なし
     * @return provinceName 地域省名称
     * @exception なし
     */
    public String getProvinceName() {
        return this.provinceName;
    }

    /**
     * 地域省名称を設定する。
     * @param provinceName 地域省名称
     * @return なし
     * @exception なし
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 地域市名称を取得する。
     * @param なし
     * @return cityName 地域市名称
     * @exception なし
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * 地域市名称を設定する。
     * @param cityName 地域市名称
     * @return なし
     * @exception なし
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 地域区/?名称を取得する。
     * @param なし
     * @return countryName 地域区/?名称
     * @exception なし
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     * 地域区/?名称を設定する。
     * @param countryName 地域区/?名称
     * @return なし
     * @exception なし
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * 補助金を取得する。
     * @param なし
     * @return travelMoney 補助金
     * @exception なし
     */
    public BigDecimal getTravelMoney() {
        return this.travelMoney;
    }

    /**
     * 補助金を設定する。
     * @param travelMoney 補助金
     * @return なし
     * @exception なし
     */
    public void setTravelMoney(BigDecimal travelMoney) {
        this.travelMoney = travelMoney;
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
     * 地域省IDを取得する。
     * @param なし
     * @return provinceId 地域省ID
     * @exception なし
     */
	public Integer getProvinceId() {
		return provinceId;
	}
	
    /**
     * レコード地域省IDを設定する。
     * @param provinceId レコード地域省ID
     * @return なし
     * @exception なし
     */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	/**
     * 地域市IDを取得する。
     * @param なし
     * @return cityId 地域市ID
     * @exception なし
     */
	public Integer getCityId() {
		return cityId;
	}
	
	/**
     * レコード地域市IDを設定する。
     * @param cityId レコード地域市ID
     * @return なし
     * @exception なし
     */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
    /**
     * レコード更新実年月日時分秒を取得する。
     * @param なし
     * @return recKosnZituYmdHmsStrレコード更新実年月日時分秒
     * @exception なし
     */
	public String getRecKosnZituYmdHmsStr() {
		return recKosnZituYmdHmsStr;
	}
	   /**
     * レコード更新実年月日時分秒を設定する。
     * @param recKosnZituYmdHmsStr レコード更新実年月日時分秒
     * @return なし
     * @exception なし
     */
	public void setRecKosnZituYmdHmsStr(String recKosnZituYmdHmsStr) {
		this.recKosnZituYmdHmsStr = recKosnZituYmdHmsStr;
	}
	 /**
     * 補助金を取得する。
     * @param なし
     * @return travelMoneyStr 補助金
     * @exception なし
     */
	public String getTravelMoneyStr() {
		return travelMoneyStr;
	}
	  /**
     * 補助金を設定する。
     * @param travelMoneyStr 補助金
     * @return なし
     * @exception なし
     */
	public void setTravelMoneyStr(String travelMoneyStr) {
		this.travelMoneyStr = travelMoneyStr;
	}
}
