package com.zzq.leetcode.剑指offer;

public class 剑指offer左右两边子数组的和相等 {
	public int pivotIndex(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			if (curSum - nums[i] == sum - curSum) {
				return i;
			}
		}
		return -1;
	}
}
