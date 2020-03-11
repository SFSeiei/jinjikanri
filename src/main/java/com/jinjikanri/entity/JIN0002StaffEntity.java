package com.jinjikanri.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 人員基本情報<BR>
 * 人員基本情報各项目の内容一覧<BR>
 * @author 日立 陳俊霖 2019/12/27
 */
public class JIN0002StaffEntity {

	/**
     * 従業員コード。
     */
	private Integer staffCd;

    /**
     * 所属部門。
     */
    private String dePartMent;

    /**
     * 名前。
     */
    private String name;

    /**
     * 証件類型。
     */
    private String idRuikei;

    /**
     * 証件番号。
     */
    private String idNumber;

    /**
     * 性別。
     */
    private String sex;

    /**
     * 職務。
     */
    private String posiTion;

    /**
     * 課長。
     */
    private String secTionManager;

    /**
     * 部長。
     */
    private String miniSter;

    /**
     * 民族。
     */
    private String naTion;

    /**
     * 出身地。
     */
    private String birthAddress;

    /**
     * 卒業日付。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graduationTime;

    /**
     * 卒業学校。
     */
    private String graduationSchool;

    /**
     * 専攻科目。
     */
    private String majorStudied;

    /**
     * 生誕日付。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    /**
     * 入社日付。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;

    /**
     * 政治様相。
     */
    private String politicaloutLook;

    /**
     * 教養程度。
     */
    private String educationDegree;

    /**
     * 戸籍性質。
     */
    private String accountCharacter;

    /**
     * 戸籍登録日付。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date accountregistrationDate;

    /**
     * 戸籍所在地。
     */
    private String registrationResidence;

    /**
     * 常住場所。
     */
    private String permanentAddress;

    /**
     * 職業資格等級。
     */
    private String professionalLevel;

    /**
     * 取得職業資格日付。
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date professionallevelDate;

    /**
     * 取得国家職業資格等級職業名前。
     */
    private String nameofWork;

    /**
     * 連絡電話。
     */
    private String contactNumber;

    /**
     * E-MAIL場所。
     */
    private String eMail;

    /**
     * 郵便番号。
     */
    private String postalCode;

    /**
     * レコード作成実年月日時分秒。
     */
    private Timestamp recsakszituymdhms;

    /**
     * レコード更新実年月日時分秒。
     */
    private Timestamp reckosnzituymdhms;

    /**
     * 更新実年月日時分秒。
     */
    private String kosnzituymdhms;

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
     * 所属部門を取得する。
     * @param なし
     * @return dePartMent 所属部門
     * @exception なし
     */
    public String getDePartMent() {
        return this.dePartMent;
    }

    /**
     * 所属部門を設定する。
     * @param dePartMent 所属部門
     * @return なし
     * @exception なし
     */
    public void setDePartMent(String dePartMent) {
        this.dePartMent = dePartMent;
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
     * 証件類型を取得する。
     * @param なし
     * @return idRuikei 証件類型
     * @exception なし
     */
    public String getIdRuikei() {
        return this.idRuikei;
    }

    /**
     * 証件類型を設定する。
     * @param idRuikei 証件類型
     * @return なし
     * @exception なし
     */
    public void setIdRuikei(String idRuikei) {
        this.idRuikei = idRuikei;
    }

    /**
     * 証件番号を取得する。
     * @param なし
     * @return idNumber 証件番号
     * @exception なし
     */
    public String getIdNumber() {
        return this.idNumber;
    }

    /**
     * 証件番号を設定する。
     * @param idNumber 証件番号
     * @return なし
     * @exception なし
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 性別を取得する。
     * @param なし
     * @return sex 性別
     * @exception なし
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 性別を設定する。
     * @param sex 性別
     * @return なし
     * @exception なし
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 職務を取得する。
     * @param なし
     * @return posiTion 職務
     * @exception なし
     */
    public String getPosiTion() {
        return this.posiTion;
    }

    /**
     * 職務を設定する。
     * @param posiTion 職務
     * @return なし
     * @exception なし
     */
    public void setPosiTion(String posiTion) {
        this.posiTion = posiTion;
    }

    /**
     * 課長を取得する。
     * @param なし
     * @return secTionManager 課長
     * @exception なし
     */
    public String getSecTionManager() {
        return this.secTionManager;
    }

    /**
     * 課長を設定する。
     * @param secTionManager 課長
     * @return なし
     * @exception なし
     */
    public void setSecTionManager(String secTionManager) {
        this.secTionManager = secTionManager;
    }

    /**
     * 部長を取得する。
     * @param なし
     * @return miniSter 部長
     * @exception なし
     */
    public String getMiniSter() {
        return this.miniSter;
    }

    /**
     * 部長を設定する。
     * @param miniSter 部長
     * @return なし
     * @exception なし
     */
    public void setMiniSter(String miniSter) {
        this.miniSter = miniSter;
    }

    /**
     * 民族を取得する。
     * @param なし
     * @return naTion 民族
     * @exception なし
     */
    public String getNaTion() {
        return this.naTion;
    }

    /**
     * 民族を設定する。
     * @param naTion 民族
     * @return なし
     * @exception なし
     */
    public void setNaTion(String naTion) {
        this.naTion = naTion;
    }

    /**
     * 出身地を取得する。
     * @param なし
     * @return birthAddress 出身地
     * @exception なし
     */
    public String getBirthAddress() {
        return this.birthAddress;
    }

    /**
     * 出身地を設定する。
     * @param birthAddress 出身地
     * @return なし
     * @exception なし
     */
    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }

    /**
     * 卒業日付を取得する。
     * @param なし
     * @return graduationTime 卒業日付
     * @exception なし
     */
    public Date getGraduationTime() {
        return this.graduationTime;
    }

    /**
     * 卒業日付を設定する。
     * @param graduationTime 卒業日付
     * @return なし
     * @exception なし
     */
    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    /**
     * 卒業学校を取得する。
     * @param なし
     * @return graduationSchool 卒業学校
     * @exception なし
     */
    public String getGraduationSchool() {
        return this.graduationSchool;
    }

    /**
     * 卒業学校を設定する。
     * @param graduationSchool 卒業学校
     * @return なし
     * @exception なし
     */
    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    /**
     * 専攻科目を取得する。
     * @param なし
     * @return majorStudied 専攻科目
     * @exception なし
     */
    public String getMajorStudied() {
        return this.majorStudied;
    }

    /**
     * 専攻科目を設定する。
     * @param majorStudied 専攻科目
     * @return なし
     * @exception なし
     */
    public void setMajorStudied(String majorStudied) {
        this.majorStudied = majorStudied;
    }

    /**
     * 生誕日付を取得する。
     * @param なし
     * @return birthDate 生誕日付
     * @exception なし
     */
    public Date getBirthDate() {
        return this.birthDate;
    }

    /**
     * 生誕日付を設定する。
     * @param birthDate 生誕日付
     * @return なし
     * @exception なし
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 入社日付を取得する。
     * @param なし
     * @return entryTime 入社日付
     * @exception なし
     */
    public Date getEntryTime() {
        return this.entryTime;
    }

    /**
     * 入社日付を設定する。
     * @param entryTime 入社日付
     * @return なし
     * @exception なし
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * 政治様相を取得する。
     * @param なし
     * @return politicaloutLook 政治様相
     * @exception なし
     */
    public String getPoliticaloutLook() {
        return this.politicaloutLook;
    }

    /**
     * 政治様相を設定する。
     * @param politicaloutLook 政治様相
     * @return なし
     * @exception なし
     */
    public void setPoliticaloutLook(String politicaloutLook) {
        this.politicaloutLook = politicaloutLook;
    }

    /**
     * 教養程度を取得する。
     * @param なし
     * @return educationDegree 教養程度
     * @exception なし
     */
    public String getEducationDegree() {
        return this.educationDegree;
    }

    /**
     * 教養程度を設定する。
     * @param educationDegree 教養程度
     * @return なし
     * @exception なし
     */
    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    /**
     * 戸籍性質を取得する。
     * @param なし
     * @return accountCharacter 戸籍性質
     * @exception なし
     */
    public String getAccountCharacter() {
        return this.accountCharacter;
    }

    /**
     * 戸籍性質を設定する。
     * @param accountCharacter 戸籍性質
     * @return なし
     * @exception なし
     */
    public void setAccountCharacter(String accountCharacter) {
        this.accountCharacter = accountCharacter;
    }

    /**
     * 戸籍登録日付を取得する。
     * @param なし
     * @return accountregistrationDate 戸籍登録日付
     * @exception なし
     */
    public Date getAccountregistrationDate() {
        return this.accountregistrationDate;
    }

    /**
     * 戸籍登録日付を設定する。
     * @param accountregistrationDate 戸籍登録日付
     * @return なし
     * @exception なし
     */
    public void setAccountregistrationDate(Date accountregistrationDate) {
        this.accountregistrationDate = accountregistrationDate;
    }

    /**
     * 戸籍所在地を取得する。
     * @param なし
     * @return registrationResidence 戸籍所在地
     * @exception なし
     */
    public String getRegistrationResidence() {
        return this.registrationResidence;
    }

    /**
     * 戸籍所在地を設定する。
     * @param registrationResidence 戸籍所在地
     * @return なし
     * @exception なし
     */
    public void setRegistrationResidence(String registrationResidence) {
        this.registrationResidence = registrationResidence;
    }

    /**
     * 常住場所を取得する。
     * @param なし
     * @return permanentAddress 常住場所
     * @exception なし
     */
    public String getPermanentAddress() {
        return this.permanentAddress;
    }

    /**
     * 常住場所を設定する。
     * @param permanentAddress 常住場所
     * @return なし
     * @exception なし
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * 職業資格等級を取得する。
     * @param なし
     * @return professionalLevel 職業資格等級
     * @exception なし
     */
    public String getProfessionalLevel() {
        return this.professionalLevel;
    }

    /**
     * 職業資格等級を設定する。
     * @param professionalLevel 職業資格等級
     * @return なし
     * @exception なし
     */
    public void setProfessionalLevel(String professionalLevel) {
        this.professionalLevel = professionalLevel;
    }

    /**
     * 取得職業資格日付を取得する。
     * @param なし
     * @return professionallevelDate 取得職業資格日付
     * @exception なし
     */
    public Date getProfessionallevelDate() {
        return this.professionallevelDate;
    }

    /**
     * 取得職業資格日付を設定する。
     * @param professionallevelDate 取得職業資格日付
     * @return なし
     * @exception なし
     */
    public void setProfessionallevelDate(Date professionallevelDate) {
        this.professionallevelDate = professionallevelDate;
    }

    /**
     * 取得国家職業資格等級職業名前を取得する。
     * @param なし
     * @return nameofWork 取得国家職業資格等級職業名前
     * @exception なし
     */
    public String getNameofWork() {
        return this.nameofWork;
    }

    /**
     * 取得国家職業資格等級職業名前を設定する。
     * @param nameofWork 取得国家職業資格等級職業名前
     * @return なし
     * @exception なし
     */
    public void setNameofWork(String nameofWork) {
        this.nameofWork = nameofWork;
    }

    /**
     * 連絡電話を取得する。
     * @param なし
     * @return contactNumber 連絡電話
     * @exception なし
     */
    public String getContactNumber() {
        return this.contactNumber;
    }

    /**
     * 連絡電話を設定する。
     * @param contactNumber 連絡電話
     * @return なし
     * @exception なし
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * E-MAIL場所を取得する。
     * @param なし
     * @return eMail E-MAIL場所
     * @exception なし
     */
    public String getEMail() {
        return this.eMail;
    }

    /**
     * E-MAIL場所を設定する。
     * @param eMail E-MAIL場所
     * @return なし
     * @exception なし
     */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * 郵便番号を取得する。
     * @param なし
     * @return postalCode 郵便番号
     * @exception なし
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * 郵便番号を設定する。
     * @param postalCode 郵便番号
     * @return なし
     * @exception なし
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * レコード作成実年月日時分秒を取得する。
     * @param なし
     * @return recsakszituymdhms レコード作成実年月日時分秒
     * @exception なし
     */
    public Timestamp getRecsakszituymdhms() {
        return this.recsakszituymdhms;
    }

    /**
     * レコード作成実年月日時分秒を設定する。
     * @param recsakszituymdhms レコード作成実年月日時分秒
     * @return なし
     * @exception なし
     */
    public void setRecsakszituymdhms(Timestamp recsakszituymdhms) {
        this.recsakszituymdhms = recsakszituymdhms;
    }

    /**
     * レコード更新実年月日時分秒を取得する。
     * @param なし
     * @return reckosnzituymdhms レコード更新実年月日時分秒
     * @exception なし
     */
    public Timestamp getReckosnzituymdhms() {
        return this.reckosnzituymdhms;
    }

    /**
     * レコード更新実年月日時分秒を設定する。
     * @param reckosnzituymdhms レコード更新実年月日時分秒
     * @return なし
     * @exception なし
     */
    public void setReckosnzituymdhms(Timestamp reckosnzituymdhms) {
        this.reckosnzituymdhms = reckosnzituymdhms;
    }

    /**
     * 更新実年月日時分秒を取得する。
     * @param なし
     * @return kosnzituymdhms 更新実年月日時分秒
     * @exception なし
     */
	public String getKosnzituymdhms() {
		return kosnzituymdhms;
	}

	/**
     * 更新実年月日時分秒を設定する。
     * @param kosnzituymdhms 更新実年月日時分秒
     * @return なし
     * @exception なし
     */
	public void setKosnzituymdhms(String kosnzituymdhms) {
		this.kosnzituymdhms = kosnzituymdhms;
	}

}
