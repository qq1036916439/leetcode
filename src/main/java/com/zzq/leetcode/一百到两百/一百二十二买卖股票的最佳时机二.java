package com.zzq.leetcode.一百到两百;

public class 一百二十二买卖股票的最佳时机二 {
	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < prices[i]) {
				res = res + prices[i] - prices[i - 1];
			}
		}
		return res;
	}

}
