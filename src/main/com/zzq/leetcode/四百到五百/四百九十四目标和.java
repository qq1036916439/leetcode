package com.zzq.leetcode.四百到五百;

public class 四百九十四目标和 {
	int res = 0;

	public int findTargetSumWays(int[] nums, int target) {
		back(nums, 0, target, 0);
		return res;
	}

	public void back(int[] nums, int index, int target, int sum) {
		if (nums.length == index) {
			if (sum == target) {
				res++;
			}
			return;
		}
		back(nums, index + 1, target, sum - nums[index]);
		back(nums, index + 1, target, sum + nums[index]);
	}
}
