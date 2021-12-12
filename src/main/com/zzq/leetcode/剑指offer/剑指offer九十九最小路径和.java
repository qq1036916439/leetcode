package main.com.zzq.leetcode.剑指offer;

public class 剑指offer九十九最小路径和 {
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
					continue;
				}
				if (i == 0) {
					dp[i][j] = grid[i][j] + dp[i][j - 1];
					continue;
				}
				if (j == 0) {
					dp[i][j] = grid[i][j] + dp[i - 1][j];
					continue;
				}
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
