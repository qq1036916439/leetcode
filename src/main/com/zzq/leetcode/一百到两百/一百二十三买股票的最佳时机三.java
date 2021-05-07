package com.zzq.leetcode.一百到两百;

public class 一百二十三买股票的最佳时机三 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[][][] dp = new int[prices.length][3][2];
		for (int i = 0; i < prices.length; i++) {
			for (int j = 2; j > 0; j--) {
				if (i == 0) {
					//没有进行过股票的买卖
					dp[i][j][0] = 0;
					dp[i][j][1] = -prices[i];
				} else {
					//第i天没有持有的最大值等于，i-1天没有持有 或者i-1天持有今天卖出去
					dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
					//第i天持有的最大最大值等于，i-1天持有，或者 i-1 j-1没有持有 减去 今天的价格。
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
				}
			}
		}
		return dp[prices.length - 1][2][0];
	}
}
