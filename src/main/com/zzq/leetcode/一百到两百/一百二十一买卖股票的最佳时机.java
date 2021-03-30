package com.zzq.leetcode.一百到两百;

public class 一百二十一买卖股票的最佳时机 {
	public int maxProfit(int[] prices) {
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}
}
