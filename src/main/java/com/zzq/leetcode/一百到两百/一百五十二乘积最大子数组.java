package com.zzq.leetcode.一百到两百;

public class 一百五十二乘积最大子数组 {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int curmax = max;
			int curmin = min;
			max = Math.max(Math.max(curmax * nums[i], nums[i]), nums[i] * curmin);
			min = Math.min(Math.min(curmax * nums[i], nums[i]), nums[i] * curmin);
			res = Math.max(res, max);
		}
		return res;
	}
}
