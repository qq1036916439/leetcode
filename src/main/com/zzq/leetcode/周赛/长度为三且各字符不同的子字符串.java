package com.zzq.leetcode.周赛;

import java.util.HashSet;

public class 长度为三且各字符不同的子字符串 {

	public static int countGoodSubstrings(String s) {
		int res = 0;
		char[] array = s.toCharArray();
		HashSet<Character> set = new HashSet();
		for (int i = 0; i < array.length - 2; i++) {
			for (int j = i; j < i + 3; j++) {
				if (!set.add(array[j])) {
					break;
				}
				if (j == i + 2) {
					res++;
				}
			}
			set.clear();
		}
		return res;
	}

	public static void main(String[] args) {
		countGoodSubstrings("aababcabc");
	}
}
