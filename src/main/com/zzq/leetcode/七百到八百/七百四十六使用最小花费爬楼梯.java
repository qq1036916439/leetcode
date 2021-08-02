package com.zzq.leetcode.七百到八百;

public class 七百四十六使用最小花费爬楼梯 {
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[cost.length];
	}
}
