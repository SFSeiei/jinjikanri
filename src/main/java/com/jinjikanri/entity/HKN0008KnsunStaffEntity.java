package com.jinjikanri.entity;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * パラメータの設定<BR>
 * パラメータの設定各项目の内容一覧<BR>
 * @author 日立 李春菊 2019/12/18
 */
public class HKN0008KnsunStaffEntity {

    /**
     * ID。
     */
    private Integer id;

    /**
     * 従業員ID。
     */
    private Integer staffId;

    /**
     * 名前。
     */
    private String name;

    /**
     * 健診日ID。
     */
    private Integer knsunYmdId;

    /**
     * 開始日。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date kaiseBi;

    /**
     * 終了日。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endBi;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;
    
    private HKN0007KnsunEntity hkn0007KnsunEntity;
    
    
    /**
     * IDを取得する。
     * @param なし
     * @return id ID
     * @exception なし
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * IDを設定する。
     * @param id ID
     * @return なし
     * @exception なし
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 従業員IDを取得する。
     * @param なし
     * @return staffId 従業員ID
     * @exception なし
     */
    public Integer getStaffId() {
        return this.staffId;
    }

    /**
     * 従業員IDを設定する。
     * @param staffId 従業員ID
     * @return なし
     * @exception なし
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 名前を取得する。
     * @param なし
     * @return name 名前
     * @exception なし
     */
    public String getName() {
        return this.name;
    }

    /**
     * 名前を設定する。
     * @param name 名前
     * @return なし
     * @exception なし
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 健診日IDを取得する。
     * @param なし
     * @return knsunYmdId 健診日ID
     * @exception なし
     */
    public Integer getKnsunYmdId() {
        return this.knsunYmdId;
    }

    /**
     * 健診日IDを設定する。
     * @param knsunYmdId 健診日ID
     * @return なし
     * @exception なし
     */
    public void setKnsunYmdId(Integer knsunYmdId) {
        this.knsunYmdId = knsunYmdId;
    }

    /**
     * 開始日を取得する。
     * @param なし
     * @return kaiseBi 開始日
     * @exception なし
     */
    public Date getKaiseBi() {
        return this.kaiseBi;
    }

    /**
     * 開始日を設定する。
     * @param kaiseBi 開始日
     * @return なし
     * @exception なし
     */
    public void setKaiseBi(Date kaiseBi) {
        this.kaiseBi = kaiseBi;
    }

    /**
     * 終了日を取得する。
     * @param なし
     * @return endBi 終了日
     * @exception なし
     */
    public Date getEndBi() {
        return this.endBi;
    }

    /**
     * 終了日を設定する。
     * @param endBi 終了日
     * @return なし
     * @exception なし
     */
    public void setEndBi(Date endBi) {
        this.endBi = endBi;
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

	public HKN0007KnsunEntity getHkn0007KnsunEntity() {
		return hkn0007KnsunEntity;
	}

	public void setHkn0007KnsunEntity(HKN0007KnsunEntity hkn0007KnsunEntity) {
		this.hkn0007KnsunEntity = hkn0007KnsunEntity;
	}

}

