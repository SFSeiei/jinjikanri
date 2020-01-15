package com.jinjikanri.entity;

import java.sql.Timestamp;

/**
 * シャトルバス情報<BR>
 * シャトルバス情報の内容一覧<BR>
 * @author 田柳　2020/01/08
 *
 */
public class HKN0005LicenseEntity {

	/**
	 * バス号。
	 */
	private Integer busId;

	/**
	 * 車のナンバー。
	 */
	private String licenseId;

	/**
	 * 従業員コード。
	 */
	private Integer staffCd;

	/**
	 * 車種。
	 */
	private String vehicleType;

	/**
	 * 班次。
	 */
	private Integer classes;

	/**
	 * シャトルバスの路線。
	 */
	private String course;

	/**
	 * 連絡先の区域。
	 */
	private Integer locationId;

	/**
	 * 連絡先。
	 */
	private String destination;

	/**
	 * レコード作成実年月日時分秒。
	 */
	private Timestamp recSaksZituYmdHms;

	/**
	 * レコード更新実年月日時分秒。
	 */
	private Timestamp recKosnZituYmdHms;

	/**
	 * 運転手詳細。
	 */
	private String driverDetails;

	/**
	 * 運転手の名前。
	 */
	private String name;

	/**
	 * 運転手の性別。
	 */
	private String sex;

	/**
	 * バス号を取得する。
	 * 
	 * @param なし
	 * @return busId バス号
	 * @exception なし
	 */
	public Integer getBusId() {
		return this.busId;
	}

	/**
	 * バス号を設定する。
	 * 
	 * @param busId バス号
	 * @return なし
	 * @exception なし
	 */
	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	/**
	 * 車のナンバーを取得する。
	 * 
	 * @param なし
	 * @return licenseId 車のナンバー
	 * @exception なし
	 */
	public String getLicenseId() {
		return this.licenseId;
	}

	/**
	 * 車のナンバーを設定する。
	 * 
	 * @param licenseId 車のナンバー
	 * @return なし
	 * @exception なし
	 */
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	/**
	 * 従業員コードを取得する。
	 * 
	 * @param なし
	 * @return staffCd 従業員コード
	 * @exception なし
	 */
	public Integer getStaffCd() {
		return this.staffCd;
	}

	/**
	 * 従業員コードを設定する。
	 * 
	 * @param staffCd 従業員コード
	 * @return なし
	 * @exception なし
	 */
	public void setStaffCd(Integer staffCd) {
		this.staffCd = staffCd;
	}

	/**
	 * 車種を取得する。
	 * 
	 * @param なし
	 * @return vehicleType 車種
	 * @exception なし
	 */
	public String getVehicleType() {
		return this.vehicleType;
	}

	/**
	 * 車種を設定する。
	 * 
	 * @param vehicleType 車種
	 * @return なし
	 * @exception なし
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * 班次を取得する。
	 * 
	 * @param なし
	 * @return classes 班次
	 * @exception なし
	 */
	public Integer getClasses() {
		return this.classes;
	}

	/**
	 * 班次を設定する。
	 * 
	 * @param classes 班次
	 * @return なし
	 * @exception なし
	 */
	public void setClasses(Integer classes) {
		this.classes = classes;
	}

	/**
	 * シャトルバスの路線を取得する。
	 * 
	 * @param なし
	 * @return course シャトルバスの路線
	 * @exception なし
	 */
	public String getCourse() {
		return this.course;
	}

	/**
	 * シャトルバスの路線を設定する。
	 * 
	 * @param course シャトルバスの路線
	 * @return なし
	 * @exception なし
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * 連絡先の区域を取得する。
	 * 
	 * @param なし
	 * @return locationId 連絡先の区域
	 * @exception なし
	 */
	public Integer getLocationId() {
		return this.locationId;
	}

	/**
	 * 連絡先の区域を設定する。
	 * 
	 * @param locationId 連絡先の区域
	 * @return なし
	 * @exception なし
	 */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	/**
	 * 連絡先を取得する。
	 * 
	 * @param なし
	 * @return destination 連絡先
	 * @exception なし
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * 連絡先を設定する。
	 * 
	 * @param destination 連絡先
	 * @return なし
	 * @exception なし
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * レコード作成実年月日時分秒を取得する。
	 * 
	 * @param なし
	 * @return recSaksZituYmdHms レコード作成実年月日時分秒
	 * @exception なし
	 */
	public Timestamp getRecSaksZituYmdHms() {
		return this.recSaksZituYmdHms;
	}

	/**
	 * レコード作成実年月日時分秒を設定する。
	 * 
	 * @param recSaksZituYmdHms レコード作成実年月日時分秒
	 * @return なし
	 * @exception なし
	 */
	public void setRecSaksZituYmdHms(Timestamp recSaksZituYmdHms) {
		this.recSaksZituYmdHms = recSaksZituYmdHms;
	}

	/**
	 * レコード更新実年月日時分秒を取得する。
	 * 
	 * @param なし
	 * @return recKosnZituYmdHms レコード更新実年月日時分秒
	 * @exception なし
	 */
	public Timestamp getRecKosnZituYmdHms() {
		return this.recKosnZituYmdHms;
	}

	/**
	 * レコード更新実年月日時分秒を設定する。
	 * 
	 * @param recKosnZituYmdHms レコード更新実年月日時分秒
	 * @return なし
	 * @exception なし
	 */
	public void setRecKosnZituYmdHms(Timestamp recKosnZituYmdHms) {
		this.recKosnZituYmdHms = recKosnZituYmdHms;
	}

	/**
	 * 運転手詳細を取得する。
	 * 
	 * @param なし
	 * @return driverDetails 従業員コード
	 * @exception なし
	 */
	public String getDriverDetails() {
		return this.driverDetails;
	}

	/**
	 * 運転手詳細を設定する。
	 * 
	 * @param driverDetails 従業員コード
	 * @return なし
	 * @exception なし
	 */
	public void setDriverDretails(String driverDetails) {
		this.driverDetails = driverDetails;
	}

	/**
	 * 運転手の名前を取得する。
	 * 
	 * @param なし
	 * @return name 運転手の名前
	 * @exception なし
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 運転手の名前を設定する。
	 * 
	 * @param name 運転手の名前
	 * @return なし
	 * @exception なし
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 運転手の性別を取得する。
	 * 
	 * @param なし
	 * @return sex 運転手の性別
	 * @exception なし
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * 運転手の性別を設定する。
	 * 
	 * @param sex 運転手の性別
	 * @return なし
	 * @exception なし
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
}
