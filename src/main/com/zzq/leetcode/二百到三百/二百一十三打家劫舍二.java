package com.zzq.leetcode.二百到三百;

public class 二百一十三打家劫舍二 {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] num1 = new int[nums.length - 1];
		int[] num2 = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; i++) {
			num1[i] = nums[i];
			num2[i] = nums[nums.length - 1 - i];
		}
		return Math.max(singleTreatment(num1), singleTreatment(num2));
	}

	public int singleTreatment(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		} else {
			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < dp.length; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
			}
			return dp[dp.length - 1];
		}
	}

	/**
	 *	滚动数组空间优化
	 */
	public int rob2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(rob(nums, 1, nums.length-1), rob(nums, 0, nums.length - 2));
	}

	public int rob(int[] nums, int start, int end) {
		int first = nums[start];
		int second = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <=end; i++) {
			int tem = second;
			second = Math.max(nums[i] + first, second);
			first = tem;
		}
		return second;
	}
}
