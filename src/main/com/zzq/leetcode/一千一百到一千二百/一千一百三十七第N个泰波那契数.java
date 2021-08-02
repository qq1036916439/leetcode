package com.zzq.leetcode.一千一百到一千二百;

public class 一千一百三十七第N个泰波那契数 {
	public int tribonacci(int n) {
		if (n < 2) {
			return n;
		}
		int first = 0;
		int second = 1;
		int third = 1;
		for (int i = 3; i <= n; i++) {
			int tem = third;

			third = second + first + third;
			first = second;
			second = tem;
		}
		return third;
	}
}
