package com.zzq.leetcode.一百到两百;

public class 一百九十八打家劫舍 {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}

	/**
	 * 滚动数组空间优化
	 */
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		return rob(nums, 0, nums.length);
	}

	public int rob(int[] nums, int start, int end) {
		int first = nums[start];
		int second = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i < end; i++) {
			int tem = second;
			second = Math.max(nums[i] + first, second);
			first = tem;
		}
		return second;
	}
}
