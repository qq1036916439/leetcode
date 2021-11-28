package com.zzq.leetcode.一到一百;

public class 六十二不同路径 {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
