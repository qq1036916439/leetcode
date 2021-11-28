package com.zzq.leetcode.剑指offer;

public class 剑指Offer四十二连续子数组的最大和 {
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
