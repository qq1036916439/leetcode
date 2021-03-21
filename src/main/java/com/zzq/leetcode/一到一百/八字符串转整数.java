package com.zzq.leetcode.一到一百;

public class 八字符串转整数 {
	public int myAtoi(String s) {
		if (s == "" || s.length() == 0 || s == null) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int index = 0;
		while (index < chars.length && chars[index] == ' ') {
			index++;
		}
		if (index == chars.length) {
			return 0;
		}
		int num = 1;
		if (chars[index] == '+') {
			index++;
		} else {
			if (chars[index] == '-') {
				index++;
				num = -1;
			}
		}
		if (index >= chars.length || chars[index] > '9' || chars[index] < '0') {
			return 0;
		}
		int res = 0;
		while (index < chars.length) {
			if (chars[index] > '9' || chars[index] < '0') {
				return res;
			}
			int l = chars[index] - '0';
			if (res > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < l)) {
				return Integer.MAX_VALUE;
			}
			if (res < Integer.MIN_VALUE / 10 || (Integer.MIN_VALUE / 10 == res && -(Integer.MIN_VALUE % 10) < l)) {
				return Integer.MIN_VALUE;
			}
			res = res * 10 + l * num;
			index++;
		}
		return res;
	}
}
