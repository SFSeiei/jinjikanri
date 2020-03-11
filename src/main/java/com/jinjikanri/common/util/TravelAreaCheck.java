package com.jinjikanri.common.util;

import java.math.BigDecimal;

import com.jinjikanri.entity.HKN0003TravelAreaEntity;

public class TravelAreaCheck {
	private static String province;
	private static String city;
	private static String country;
	private static String travelMoney;
	
	/**
	 * 画面入力項目単項目チェック
	 * @param travelArea HKN0003TravelAreamEntityオブジェクト
	 * @param errorList エラーメッセージアレイ
	 * @return isTrue エラーフラグ
	 */
	public static boolean singleCheck(HKN0003TravelAreaEntity travelArea) {
		String reg = "(^[1-9](\\d+)?(\\.\\d+)?$)|(^0$)|(^\\d\\.\\d+$)";
		String reg1 = "(^[1-9](\\d{0,9})?(\\.\\d{1,2})?$)|(^0$)|(^\\d{0,10}\\.\\d{1,2}$)";
		boolean isTrue = true;
		//	0画面入力を取得した出張地域省		
		province = travelArea.getProvinceName();
		//  0画面入力を取得した出張地域市
		city = travelArea.getCityName();
		//  0画面入力を取得した出張地域区/县
		country = travelArea.getCountryName();
		//  0画面入力を取得した補助金
		travelMoney = travelArea.getTravelMoneyStr();
	
		//	0出張地域省単項目必須チェック	
		if (Tools.isNull(province)) {
			isTrue = false;
		} 
		//	0出張地域市単項目必須チェック 	
		if (Tools.isNull(city)) {
			isTrue = false;
		} 
		//	0出張地域区/县単項目必須チェック	
		if (Tools.isNull(country)) {
			isTrue = false;
		} 
		//	0補助金単項目必須チェック	
		if (Tools.isNull(travelMoney)) {
			isTrue = false;
		} else if (!travelMoney.matches(reg)) {	
			// 	0補助金単項目属性チェック		
			isTrue = false;
		} else {
			//	0補助金単項目範囲チェック
			int a = new BigDecimal(travelMoney).compareTo(new BigDecimal("9999999999.99"));
			int b = new BigDecimal(travelMoney).compareTo(BigDecimal.ZERO);
			if ((a == -1 || a == 0) && (b == 1 || b == 0)) {
				isTrue = true;
			} else {
				isTrue = false;
			}
		} 
		return isTrue;
	}
}
