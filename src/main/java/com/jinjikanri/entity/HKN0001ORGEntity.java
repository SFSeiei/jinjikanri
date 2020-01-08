package com.jinjikanri.entity;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



/**
 * 組織情報検索
 * @author zhangwenjie 2019/12/19
 *
 */



public class HKN0001ORGEntity {
	/**
     * 組織コード。
     */
/*	@NotNull(message=" 組織コード未入力")*/
    private Integer organizationCd;

    /**
     * 部署名。
     */
/*	@NotNull(message=" 部署名未入力")*/
    @Length(min=0,max=10,message="入力値大きい10桁")
    private String departmentName;

    /**
     * 上位組織コード。
     */
   
    private Integer superiorOrganizationCd;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;


    /**
     * 組織コードを取得する。
     * @param なし
     * @return organizationCd 組織コード
     * @exception なし
     */
    public Integer getOrganizationCd() {
        return this.organizationCd;
    }

    /**
     * 組織コードを設定する。
     * @param organizationCd 組織コード
     * @return なし
     * @exception なし
     */
    public void setOrganizationCd(Integer organizationCd) {
        this.organizationCd = organizationCd;
    }

    /**
     * 部署名を取得する。
     * @param なし
     * @return departmentName 部署名
     * @exception なし
     */
    public String getDepartmentName() {
        return this.departmentName;
    }

    /**
     * 部署名を設定する。
     * @param departmentName 部署名
     * @return なし
     * @exception なし
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 上位組織コードを取得する。
     * @param なし
     * @return superiorOrganizationCd 上位組織コード
     * @exception なし
     */
    public Integer getSuperiorOrganizationCd() {
        return this.superiorOrganizationCd;
    }

    /**
     * 上位組織コードを設定する。
     * @param superiorOrganizationCd 上位組織コード
     * @return なし
     * @exception なし
     */
    public void setSuperiorOrganizationCd(Integer superiorOrganizationCd) {
        this.superiorOrganizationCd = superiorOrganizationCd;
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
    
}