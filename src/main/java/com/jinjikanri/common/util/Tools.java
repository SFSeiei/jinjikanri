package com.jinjikanri.common.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Pattern;

public class Tools {
	
	//	0アレイ空を判定する
	public static boolean isNUll(List<Object> list) {
		return list.isEmpty();
	}
	//	0文字列空を判定する
	public static boolean isNull(String str) {
		return str == "" || str == null;
	}
	//	0システム時間の取得
	public static Timestamp getSysDate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	//	0String変換BigDecimal	
	public static BigDecimal transStringToBigDecimal(String number) {
		return new BigDecimal(number);
	}
	//	0String変換Timestamp
	public static Timestamp transStringToTimestamp(String date) {
		return Timestamp.valueOf(date);
	}
	// 整数を判定する
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	} 
	// 範囲を判定する
	public static boolean rangeCheck(Integer str, Integer min, Integer max) {
		if (str >= min && str <= max) {
			return true;
		} else {
			return false;
		}
	}
	
}
