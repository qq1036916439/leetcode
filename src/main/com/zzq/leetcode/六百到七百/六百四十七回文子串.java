package com.zzq.leetcode.六百到七百;

public class 六百四十七回文子串 {
	int count = 0;

	public int countSubstrings(String s) {
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			countSubstrings(i, i, array);
			countSubstrings(i, i + 1, array);
		}
		return count;
	}

	public void countSubstrings(int left, int right, char[] array) {
		while (left >= 0 && right < array.length && array[left] == array[right]) {
			count++;
			left--;
			right++;
		}
	}
}
