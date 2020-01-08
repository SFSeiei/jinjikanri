package com.jinjikanri.common.util;


public class ErrorMessage {
	
	public static String ERR0001 (String param) {
		return param+"を入力してください";
	}
	
	public static String ERR0002 (String param1, String param2) {
		return param1+"は"+param2+"桁以内で入力してください";
	}
	
	public static String ERR0003 (String param1, String param2) {
		return param1+"の値が"+param2+"ではありません";
	}
	
	public static String ERR0004 (String param1, String param2) {
		return param1+"が未入力の場合、"+param2+"は入力できません";
	}
	
	public static String ERR0005 (String param) {
		return param+"の値が半角英数字ではありません";
	}
	
	public static String ERR0006 (String param1, String param2, String param3) {
		return param1+"は"+param2+"~"+param3+"桁で入力してください";
	}
	
	public static String ERR0007 (String param) {
		return param+"の値が時刻ではありません";
	}
	
	public static String ERR0008 (String param) {
		return param+"の値が日付ではありません";
	}
	
	public static String ERR0009 (String param1, String param2) {
		return param1+"には"+param2+"以降日付を入力してください";
	}
	
	public static String ERR0010 (String param1, String param2) {
		return param1+"を選択されていない場合は、"+param2+"は入力できません";
	}
	
	public static String ERR0011 (String param) {
		return param+"が必須項目を入力して下さい";
	}
	
	public static String ERR0012 (String param) {
		return param+"が半角数字で入力して下さい";
	}
	
	public static String ERR0013 (String param) {
		return param+"が全角文字で入力して下さい";
	}
	
	public static String ERR0014 (String param) {
		return param+"が半角英数字で入力して下さい";
	}
	
	public static String ERR0015 (String param) {
		return param+"が実在する日付を入力して下さい";
	}
	
	public static String ERR0016 (String param) {
		return param+"正しいコードを入力して下さい";
	}
	
	public static String ERR0017 (String param1, String param2, String param3) {
		return param1+"、"+param2+"、"+param3+"の全てを入力してください";
	}
	
	public static String ERR0020 (String param) {
		return param + "はすでに登録されています。";
	}
	
	public static String ERR0021 (String param) {
		return param + "は登録されていません。";
	}
	
	public static String ERR0023 (String param) {
		return param+"が'0'以外必須に項目を入力して下さい";
	}
	
	public static String ERR0029() {
		return "該当データがありません";
	}
	
	public static String ERR0048() {
		return "指定情報が失効しました、更新してから送信してください";
	}
	
	public static String ERR0050(String param1, int param2, int param3) {
		return param1+"の整数部分は"+param2+"桁以内で、小数部は"+param3+"桁以内です";
	}
	
	public static String ERR0051 (String param1, String param2) {
		return param1+"と"+param2+"が全てを入力してください";
	}

}
