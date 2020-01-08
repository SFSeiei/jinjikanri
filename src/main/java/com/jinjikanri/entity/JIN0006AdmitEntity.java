package com.jinjikanri.entity;

import java.sql.Timestamp;

public class JIN0006AdmitEntity {

    /**
     * データID。
     */
    private Integer dateId;

    /**
     * 変更者ID。
     */
    private Integer changerId;

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
     * 申請者名前。
     */
    private String applicantName;

    /**
     * 申請者ID。
     */
    private Integer applicantId;

    /**
     * 申請状態。
     */
    private Integer applicantState;

    /**
     * 承認者名前。
     */
    private String admitsName;

    /**
     * 承認者ID。
     */
    private Integer admitsId;

    /**
     * 承認状態。
     */
    private Integer recognitionState;

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
     * 変更者IDを取得する。
     * @param なし
     * @return changerId 変更者ID
     * @exception なし
     */
    public Integer getChangerId() {
        return this.changerId;
    }

    /**
     * 変更者IDを設定する。
     * @param changerId 変更者ID
     * @return なし
     * @exception なし
     */
    public void setChangerId(Integer changerId) {
        this.changerId = changerId;
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
     * 申請者IDを取得する。
     * @param なし
     * @return applicant＿id 申請者ID
     * @exception なし
     */
    public Integer getApplicantId() {
        return this.applicantId;
    }

    /**
     * 申請者IDを設定する。
     * @param applicant＿id 申請者ID
     * @return なし
     * @exception なし
     */
    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    /**
     * 申請状態を取得する。
     * @param なし
     * @return applicationState 申請状態
     * @exception なし
     */
    public Integer getApplicantState() {
        return this.applicantState;
    }

    /**
     * 申請状態を設定する。
     * @param applicationState 申請状態
     * @return なし
     * @exception なし
     */
    public void setApplicantState(Integer applicantState) {
        this.applicantState = applicantState;
    }

    /**
     * 承認者名前を取得する。
     * @param なし
     * @return admitsName 承認者名前
     * @exception なし
     */
    public String getAdmitsName() {
        return this.admitsName;
    }

    /**
     * 承認者名前を設定する。
     * @param admitsName 承認者名前
     * @return なし
     * @exception なし
     */
    public void setAdmitsName(String admitsName) {
        this.admitsName = admitsName;
    }

    /**
     * 承認者IDを取得する。
     * @param なし
     * @return admitsId 承認者ID
     * @exception なし
     */
    public Integer getAdmitsId() {
        return this.admitsId;
    }

    /**
     * 承認者IDを設定する。
     * @param admitsId 承認者ID
     * @return なし
     * @exception なし
     */
    public void setAdmitsId(Integer admitsId) {
        this.admitsId = admitsId;
    }

    /**
     * 承認状態を取得する。
     * @param なし
     * @return recognitionState 承認状態
     * @exception なし
     */
    public Integer getRecognitionState() {
        return this.recognitionState;
    }

    /**
     * 承認状態を設定する。
     * @param recognitionState 承認状態
     * @return なし
     * @exception なし
     */
    public void setRecognitionState(Integer recognitionState) {
        this.recognitionState = recognitionState;
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
