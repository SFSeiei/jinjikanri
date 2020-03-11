package com.jinjikanri.entity;

import java.sql.Timestamp;

public class JIN0003QbbgEntity {
	/**
     * データID。
     */
    private Integer dateId;

    /**
     * 変更者従業員ID。
     */
    private Integer changerStaffId;

    /**
     * 変更者名前。
     */
    private String changerName;

    /**
     * 変更内容。
     */
    private String changeContent;

    /**
     * 変更前。
     */
    private String changeBefore;

    /**
     * 変更後。
     */
    private String changeAfter;

    /**
     * 申請者従業員ID。
     */
    private Integer applicantStaffId;

    /**
     * 申請者名前。
     */
    private String applicantName;

    /**
     * 承認者従業員ID。
     */
    private Integer confirmStaffId;

    /**
     * 承認者名前。
     */
    private String confirmName;

    /**
     * 申請状態。
     */
    private Integer applicantState;

    /**
     * 承認状態。
     */
    private Integer confirmState;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recSaksZituYmdHms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp recKosnZituYmdHms;


    /**
     * データIDを取得する。
     * @param なし
     * @return dateId データID
     * @exception なし
     */
    public Integer getDateId() {
        return this.dateId;
    }

    /**
     * データIDを設定する。
     * @param dateId データID
     * @return なし
     * @exception なし
     */
    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    /**
     * 変更者従業員IDを取得する。
     * @param なし
     * @return changerStaffId 変更者従業員ID
     * @exception なし
     */
    public Integer getChangerStaffId() {
        return this.changerStaffId;
    }

    /**
     * 変更者従業員IDを設定する。
     * @param changerStaffId 変更者従業員ID
     * @return なし
     * @exception なし
     */
    public void setChangerStaffId(Integer changerStaffId) {
        this.changerStaffId = changerStaffId;
    }

    /**
     * 変更者名前を取得する。
     * @param なし
     * @return changerName 変更者名前
     * @exception なし
     */
    public String getChangerName() {
        return this.changerName;
    }

    /**
     * 変更者名前を設定する。
     * @param changerName 変更者名前
     * @return なし
     * @exception なし
     */
    public void setChangerName(String changerName) {
        this.changerName = changerName;
    }

    /**
     * 変更内容を取得する。
     * @param なし
     * @return changeContent 変更内容
     * @exception なし
     */
    public String getChangeContent() {
        return this.changeContent;
    }

    /**
     * 変更内容を設定する。
     * @param changeContent 変更内容
     * @return なし
     * @exception なし
     */
    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    /**
     * 変更前を取得する。
     * @param なし
     * @return changeBefore 変更前
     * @exception なし
     */
    public String getChangeBefore() {
        return this.changeBefore;
    }

    /**
     * 変更前を設定する。
     * @param changeBefore 変更前
     * @return なし
     * @exception なし
     */
    public void setChangeBefore(String changeBefore) {
        this.changeBefore = changeBefore;
    }

    /**
     * 変更後を取得する。
     * @param なし
     * @return changeAfter 変更後
     * @exception なし
     */
    public String getChangeAfter() {
        return this.changeAfter;
    }

    /**
     * 変更後を設定する。
     * @param changeAfter 変更後
     * @return なし
     * @exception なし
     */
    public void setChangeAfter(String changeAfter) {
        this.changeAfter = changeAfter;
    }

    /**
     * 申請者従業員IDを取得する。
     * @param なし
     * @return applicantStaffId 申請者従業員ID
     * @exception なし
     */
    public Integer getApplicantStaffId() {
        return this.applicantStaffId;
    }

    /**
     * 申請者従業員IDを設定する。
     * @param applicantStaffId 申請者従業員ID
     * @return なし
     * @exception なし
     */
    public void setApplicantStaffId(Integer applicantStaffId) {
        this.applicantStaffId = applicantStaffId;
    }

    /**
     * 申請者名前を取得する。
     * @param なし
     * @return applicantName 申請者名前
     * @exception なし
     */
    public String getApplicantName() {
        return this.applicantName;
    }

    /**
     * 申請者名前を設定する。
     * @param applicantName 申請者名前
     * @return なし
     * @exception なし
     */
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    /**
     * 承認者従業員IDを取得する。
     * @param なし
     * @return confirmStaffId 承認者従業員ID
     * @exception なし
     */
    public Integer getConfirmStaffId() {
        return this.confirmStaffId;
    }

    /**
     * 承認者従業員IDを設定する。
     * @param confirmStaffId 承認者従業員ID
     * @return なし
     * @exception なし
     */
    public void setConfirmStaffId(Integer confirmStaffId) {
        this.confirmStaffId = confirmStaffId;
    }

    /**
     * 承認者名前を取得する。
     * @param なし
     * @return confirmName 承認者名前
     * @exception なし
     */
    public String getConfirmName() {
        return this.confirmName;
    }

    /**
     * 承認者名前を設定する。
     * @param confirmName 承認者名前
     * @return なし
     * @exception なし
     */
    public void setConfirmName(String confirmName) {
        this.confirmName = confirmName;
    }

    /**
     * 申請状態を取得する。
     * @param なし
     * @return applicantState 申請状態
     * @exception なし
     */
    public Integer getApplicantState() {
        return this.applicantState;
    }

    /**
     * 申請状態を設定する。
     * @param applicantState 申請状態
     * @return なし
     * @exception なし
     */
    public void setApplicantState(Integer applicantState) {
        this.applicantState = applicantState;
    }

    /**
     * 承認状態を取得する。
     * @param なし
     * @return confirmState 承認状態
     * @exception なし
     */
    public Integer getConfirmState() {
        return this.confirmState;
    }

    /**
     * 承認状態を設定する。
     * @param confirmState 承認状態
     * @return なし
     * @exception なし
     */
    public void setConfirmState(Integer confirmState) {
        this.confirmState = confirmState;
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
