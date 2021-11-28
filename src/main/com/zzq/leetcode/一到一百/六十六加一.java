package com.zzq.leetcode.一到一百;

public class 六十六加一 {
	public int[] plusOne(int[] digits) {
		int cur = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				int num = digits[i] + 1;
				cur = num / 10;
				digits[i] = num % 10;
			} else {
				int num = cur + digits[i];
				digits[i] = num % 10;
				cur = num / 10;
			}
		}
		if (digits[0] == 0) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}
}
