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
}
