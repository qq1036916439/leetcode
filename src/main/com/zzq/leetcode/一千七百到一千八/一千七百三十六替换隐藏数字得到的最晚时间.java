package com.zzq.leetcode.一千七百到一千八;

public class 一千七百三十六替换隐藏数字得到的最晚时间 {
	public String maximumTime(String time) {
		char[] chars = time.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '?') {
				if (i == 1) {
					if (chars[0] == '2') {
						chars[i] = '3';
					} else {
						chars[i] = '9';
					}
				}
				if (i == 0) {
					if (chars[1] >= '4' && chars[1] != '?') {
						chars[i] = '1';
					} else {
						chars[i] = '2';
					}
				}
				if (i == 3) {
					chars[i] = '5';
				}
				if (i == 4) {
					chars[i] = '9';
				}
			}
		}
		return new String(chars);
	}
}
