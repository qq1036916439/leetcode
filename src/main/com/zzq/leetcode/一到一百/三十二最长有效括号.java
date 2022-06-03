package com.zzq.leetcode.一到一百;

public class 三十二最长有效括号 {
	public int longestValidParentheses(String s) {
		char[] array = s.toCharArray();
		int[] dp = new int[array.length];
		int res = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == ')') {
				int pre = i - dp[i - 1] - 1;
				if (pre >= 0 && array[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
