package com.zzq.leetcode.剑指offer;

public class 剑指offer和大于等于target的最短子数组 {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		while (right < nums.length) {
			sum += nums[right];
			right++;
			while (left < right && sum >= target) {
				res = Math.min(res, right - left);
				sum -= nums[left];
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
