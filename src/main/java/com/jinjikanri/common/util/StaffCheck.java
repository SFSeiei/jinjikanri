package com.jinjikanri.common.util;

import java.text.SimpleDateFormat;

import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.entity.JIN0002StaffEntity;

/**
 * パラメータチェックステージ。<BR>
 * 変更照会のパラメータチェックを順次実行する。<BR>
 * @author 陳俊霖 2019/12/31
 */
public class StaffCheck {

	/**
	 * パラメータチェックステージ。<BR>
	 * 変更照会のパラメータチェックを順次実行する。<BR>
	 * @param staffEntity 人員基本情報
	 * @return boolean
	 */
	public static boolean doTanKoumokuCheck(JIN0002StaffEntity staffEntity) {
		boolean isTrue = true;
		// 漢字属性
		String word = "^[\\u4e00-\\u9fa5]{0,}$";
		// 住民身分証属性
		String idcard =
				"(^[1-9]\\d{5}(18|19|20|(3\\d))\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)";
		// パスポート属性
		String passport1 = "(^[a-zA-Z]{5,17}$)";
		String passport2 = "(^[a-zA-Z0-9]{5,17}$)";
		// 香港とマカオの通行証属性
		String hkmakao = "(^[a-zA-Z0-9]{5,21}$)";
		// 台湾通行証属性
		String taiwan1 = "(^[0-9]{8}$)";
		String taiwan2 = "(^[0-9]{10}$)";
		// 日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = "(^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$)";
		// 連絡電話属性
		String mobile = "(^1(3|4|5|6|7|8|9)\\d{9}$)";
		String tel = "(^\\d{3}-\\d{8}|\\d{4}-\\d{7}$)";
		// E-MAIL場所属性
		String email = "(^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$)";
		// 郵便番号属性
		String zipcode1 = "(^[0-9]{6}$)";
		String zipcode2 = "(^[0-9]{3}-[0-9]{4}$)";

		// 所属部門
		String dePartMent = staffEntity.getDePartMent();
		// 名前
		String name = staffEntity.getName();
		// 性別
		String sex = staffEntity.getSex();
		// 職務
		String posiTion = staffEntity.getPosiTion();
		// 課長
		String secTionManager = staffEntity.getSecTionManager();
		// 部長
		String miniSter = staffEntity.getMiniSter();
		// 証件類型
		String idRuikei = staffEntity.getIdRuikei();
		// 証件番号
		String idNumber = staffEntity.getIdNumber();
		// 政治様相
		String politicaloutLook = staffEntity.getPoliticaloutLook();
		// 教養程度
		String educationDegree = staffEntity.getEducationDegree();
		// 戸籍性質
		String accountCharacter = staffEntity.getAccountCharacter();
		// 職業資格等級
		String professionalLevel = staffEntity.getProfessionalLevel();
		// 取得国家職業資格等級職業名前
		String nameofWork = staffEntity.getNameofWork();
		// 連絡電話
		String contactNumber = staffEntity.getContactNumber();
		// E-MAIL場所
		String eMail = staffEntity.getEMail();
		// 郵便番号
		String postalCode = staffEntity.getPostalCode();

		// 所属部門必須チェック
		if (Tools.isNull(dePartMent)) {
			isTrue = false;
		}
		// 所属部門属性チェック
		else if (!dePartMent.matches(word)) {
			isTrue = false;
		}

		// 名前必須チェック
		if (Tools.isNull(name)) {
			isTrue = false;
		}
		// 名前属性チェック
		else if (!name.matches(word)) {
			isTrue = false;
		}

		// 性別その他チェック
		if (!ItemConstant.SEX_OTK.equals(sex) &&
				!ItemConstant.SEX_ONNA.equals(sex)) {
			isTrue = false;
		}

		// 職務必須チェック
		if (Tools.isNull(posiTion)) {
			isTrue = false;
		}
		// 職務属性チェック
		else if (!posiTion.matches(word)) {
			isTrue = false;
		}

		// 課長必須チェック
		if (Tools.isNull(secTionManager)) {
			isTrue = false;
		}
		// 課長属性チェック
		else if (!secTionManager.matches(word)) {
			isTrue = false;
		}
		
		// 部長必須チェック
		if (Tools.isNull(miniSter)) {
			isTrue = false;
		}
		// 部長属性チェック
		else if (!miniSter.matches(word)) {
			isTrue = false;
		}

		// 証件類型属性チェック
		if (ItemConstant.DOCUMENTS_ID.equals(idRuikei)) {
			if (!idNumber.matches(idcard)) {
				isTrue = false;
			}
		} else if (ItemConstant.DOCUMENTS_PASSPORT.equals(
				idRuikei)) {
			if (!idNumber.matches(passport1) &&
					!idNumber.matches(passport2)) {
				isTrue = false;
			}
		} else if (ItemConstant.DOCUMENTS_HKMACAOPASS.equals(
				idRuikei)) {
			if (!idNumber.matches(hkmakao)) {
				isTrue = false;
			}
		} else if (ItemConstant.DOCUMENTS_TAIWANPASS.equals(
				idRuikei)) {
			if (!idNumber.matches(taiwan1) &&
					!idNumber.matches(taiwan2)) {
				isTrue = false;
			}
		} else {
			isTrue = false;
		}

		// 証件番号必須チェック
		if (Tools.isNull(idNumber)) {
			isTrue = false;
		}

		// 卒業日付その他チェック
		if (staffEntity.getGraduationTime() != null) {
			String graduationTime = sdf.format(
					staffEntity.getGraduationTime());
			if (!graduationTime.matches(date)) {
				isTrue = false;
			}
		}

		// 生誕日付
		if (staffEntity.getBirthDate() != null) {
			String birthDate = sdf.format(staffEntity.getBirthDate());
			if (!birthDate.matches(date)) {
				isTrue = false;
			}
		}

		// 入社日付
		if (staffEntity.getEntryTime() != null) {
			String entryTime = sdf.format(staffEntity.getEntryTime());
			if (!entryTime.matches(date)) {
				isTrue = false;
			}
		}

		// 政治様相その他チェック
		if (!Tools.isNull(politicaloutLook)) {
			if (!ItemConstant.POLITICALPHASE_PARTY.equals(
					politicaloutLook) &&
				!ItemConstant.POLITICALPHASE_GROUP.equals(
					politicaloutLook) &&
				!ItemConstant.POLITICALPHASE_CIVIL.equals(
					politicaloutLook) &&
				!ItemConstant.POLITICALPHASE_PUBLIC.equals(
					politicaloutLook)) {
				isTrue = false;
			}
		}

		// 教養程度その他チェック
		if (!Tools.isNull(educationDegree)) {
			if (!ItemConstant.EDUCATION_ILLITERACY.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_PRIMARY_SCHOOL.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_MIDDLE_SCHOOL.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_HIGH_SCHOOL.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_TECHNICAL_SCHOOL.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_MIDDLE_EXPERT.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_VOCATIONAL_HIGH.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_HIGH_EXPERT.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_UNIVERSITY.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_MASTER.equals(
					educationDegree) &&
				!ItemConstant.EDUCATION_DOCTOR.equals(
					educationDegree)) {
				isTrue = false;
			}
		}

		// 戸籍性質その他チェック
		if (!Tools.isNull(accountCharacter)) {
			if (!ItemConstant.KOJI_CITY.equals(
					accountCharacter) &&
				!ItemConstant.KOJI_COUNTRYSIDE.equals(
					accountCharacter) &&
				!ItemConstant.KOJI_OUTPROVINCECITY.equals(
					accountCharacter) &&
				!ItemConstant.KOJI_OUTPROVINCENTRYSIDE.equals(
					accountCharacter) &&
				!ItemConstant.KOJI_HK_MACAO_TAIWAN.equals(
					accountCharacter) &&
				!ItemConstant.KOJI_FOREIGNERS.equals(
					accountCharacter)) {
				isTrue = false;
			}
		}

		// 戸籍登録日付その他チェック
		if (staffEntity.getAccountregistrationDate() != null) {
			String accountregistrationDate =
					sdf.format(staffEntity.getAccountregistrationDate());
			if (!accountregistrationDate.matches(date)) {
				isTrue = false;
			}
		}

		// 職業資格等級その他チェック
		if (!Tools.isNull(professionalLevel)) {
			if (!ItemConstant.GRADE_JUNIOR_WORKER.equals(
					professionalLevel) &&
				!ItemConstant.GRADE_INTERMEDIATE_WORKER.equals(
					professionalLevel) &&
				!ItemConstant.GRADE_SENIOR_WORKER.equals(
					professionalLevel) &&
				!ItemConstant.GRADE_MECHANIC.equals(
					professionalLevel) &&
				!ItemConstant.GRADE_SENIOR_MECHANIC.equals(
					professionalLevel) &&
				!ItemConstant.GRADE_PREPARED_MECHANIC.equals(
					professionalLevel) &&
				!ItemConstant.GRADE_SPECIAL_DUTY.equals(
					professionalLevel)) {
				isTrue = false;
			}
		}

		// 取得職業資格日付その他チェック
		if (staffEntity.getProfessionallevelDate() != null) {
			String professionallevelDate =
					sdf.format(staffEntity.getProfessionallevelDate());
			if (!professionallevelDate.matches(date)) {
				isTrue = false;
			}
		}

		// 取得国家職業資格等級職業名前その他チェック
		if (!Tools.isNull(nameofWork)) {
			if (!ItemConstant.NAME_COMPANY_PERSON.equals(
					nameofWork) &&
				!ItemConstant.NAME_MAJOR_PERSON.equals(
					nameofWork) &&
				!ItemConstant.NAME_WORK_PERSON.equals(
					nameofWork) &&
				!ItemConstant.NAME_BUSINESS_PERSON.equals(
					nameofWork) &&
				!ItemConstant.NAME_FISHERIES_PERSON.equals(
					nameofWork) &&
				!ItemConstant.NAME_PRODUCTION_PERSON.equals(
					nameofWork)) {
				isTrue = false;
			}
		}

		// 連絡電話属性チェック
		if (!Tools.isNull(contactNumber)) {
			if (!contactNumber.matches(mobile) &&
					!contactNumber.matches(tel)) {
				isTrue = false;
			}
		}

		// E-MAIL場所属性チェック
		if (!Tools.isNull(eMail)) {
			if (!eMail.matches(email)) {
				isTrue = false;
			}
		}

		// 郵便番号属性チェック
		if (!Tools.isNull(postalCode)) {
			if (!postalCode.matches(zipcode1) &&
					!postalCode.matches(zipcode2)) {
				isTrue = false;
			}
		}

		return isTrue;
	}

	public static String doKoumokuSoukanCheck(
			JIN0002StaffEntity staffEntity) {
		// 日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 卒業日付
		String graduationTime = null;
		if (staffEntity.getGraduationTime() != null) {
			graduationTime = sdf.format(
					staffEntity.getGraduationTime());
		}
		// 卒業学校
		String graduationschool =
				staffEntity.getGraduationSchool();
		// 専攻科目
		String majorstudied =
				staffEntity.getMajorStudied();
		// 戸籍性質
		String accountCharacter = staffEntity.getAccountCharacter();
		// 戸籍登録日付
		String accountregistrationDate = null;
		if (staffEntity.getAccountregistrationDate() != null) {
			accountregistrationDate =
					sdf.format(staffEntity.getAccountregistrationDate());
		}
		// 戸籍所在地
		String registrationresidence =
				staffEntity.getRegistrationResidence();
		// 職業資格等級
		String professionalLevel = staffEntity.getProfessionalLevel();
		// 取得職業資格日付
		String professionallevelDate = null;
		if (staffEntity.getProfessionallevelDate() != null) {
			professionallevelDate =
					sdf.format(staffEntity.getProfessionallevelDate());
		}
		// 取得国家職業資格等級職業名前
		String nameofWork = staffEntity.getNameofWork();
		
		// 卒業情報组合 チェック
		if (!Tools.isNull(graduationTime) &&
				!Tools.isNull(graduationschool) &&
				!Tools.isNull(majorstudied)) {}
		else if (Tools.isNull(graduationTime) &&
				Tools.isNull(graduationschool) &&
				Tools.isNull(majorstudied)) {}
		else {
			return ErrorMessage.ERR0017("卒業日付", "卒業学校", "専攻科目");
		}

		// 戸籍组合 チェック
		if (!Tools.isNull(accountCharacter) &&
				!Tools.isNull(accountregistrationDate) &&
				!Tools.isNull(registrationresidence)) {}
		else if (Tools.isNull(accountCharacter) &&
				Tools.isNull(accountregistrationDate) &&
				Tools.isNull(registrationresidence)) {}
		else {
			return ErrorMessage.ERR0017("戸籍性質", "戸籍登録日付", "戸籍所在地");
		}

		// 職業组合 チェック
		if (!Tools.isNull(professionalLevel) &&
				!Tools.isNull(professionallevelDate) &&
				!Tools.isNull(nameofWork)) {}
		else if (Tools.isNull(professionalLevel) &&
				Tools.isNull(professionallevelDate) &&
				Tools.isNull(nameofWork)) {}
		else {
			return ErrorMessage.ERR0017("職業資格等級", "取得職業資格日付", "取得国家職業資格等級職業名前");
		}
		return "true";
	}
}
