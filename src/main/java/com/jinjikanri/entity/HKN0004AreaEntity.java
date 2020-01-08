package com.jinjikanri.entity;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;


public class HKN0004AreaEntity {
	
    /**
     * 地域ID。
     */
    private Integer areaId = null;

    /**
     * 地域名称。
     */
    private String areaName = null;

    /**
     * 父ID。
     */
    private Integer parentId = null;

    /**
     * レコード作成実年月日時分秒。
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:SSS")
    private Timestamp recSaksZituYmdHms = null;

    /**
     * レコード更新実年月日時分秒。
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:SSS")
    private Timestamp recKosnZituYmdHms = null;


    /**
     * 地域IDを取得する。
     * @param なし
     * @return areaId 地域ID
     * @exception なし
     */
    public Integer getAreaId() {
        return this.areaId;
    }

    /**
     * 地域IDを設定する。
     * @param areaId 地域ID
     * @return なし
     * @exception なし
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 地域名称を取得する。
     * @param なし
     * @return areaName 地域名称
     * @exception なし
     */
    public String getAreaName() {
        return this.areaName;
    }

    /**
     * 地域名称を設定する。
     * @param areaName 地域名称
     * @return なし
     * @exception なし
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 父IDを取得する。
     * @param なし
     * @return parentId 父ID
     * @exception なし
     */
    public Integer getParentId() {
        return this.parentId;
    }

    /**
     * 父IDを設定する。
     * @param parentId 父ID
     * @return なし
     * @exception なし
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
