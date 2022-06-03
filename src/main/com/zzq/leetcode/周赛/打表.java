package com.zzq.leetcode.周赛;

public class 打表 {

	private static int k = 100;

	public static int function(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = i; j <= n; j++) {
				sum += j;
				if (sum == n) {
					result++;
				}
				if (sum > n) {
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i = 1; i < k; i++) {
			System.out.println(i + " " + function(i));
		}
	}
}
