package com.jinjikanri.common.util;

public class UserCheck {
	public static Integer[] arrayDelete(int index, Integer array[]) {
		// 数组的删除其实就是覆盖前一位
		Integer[] arrNew = new Integer[array.length - 1];
		for (int i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		System.arraycopy(array, 0, arrNew, 0, arrNew.length);
		return arrNew;
	}
}
