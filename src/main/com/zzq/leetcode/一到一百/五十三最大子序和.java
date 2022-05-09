package com.zzq.leetcode.一到一百;

public class 五十三最大子序和 {
	public int maxSubArray(int[] nums) {
		int maxSum = 0;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			maxSum = Math.max(nums[i], maxSum + nums[i]);
			res = Math.max(res, maxSum);
		}
		return res;
	}
}
