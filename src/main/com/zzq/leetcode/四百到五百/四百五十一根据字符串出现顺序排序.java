package com.zzq.leetcode.四百到五百;

import java.util.Arrays;

public class 四百五十一根据字符串出现顺序排序 {

	public String frequencySort(String s) {
		int[][] array = new int[128][2];
		char[] carray = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			array[i][0] = i;
		}
		for (int i = 0; i < carray.length; i++) {
			array[carray[i]][1]++;
		}
		Arrays.sort(array, (a, b) -> b[1] - a[1]);
		String res = "";
		for (int i = 0; i < array.length; i++) {
			int count = array[i][1];
			for (int j = 0; j < count; j++) {
				res += (char) array[i][0];
			}
		}
		return res;
	}
}
