package com.zzq.leetcode.五百到六百;

public class 五百八十一最短无序连续子数组 {
	public int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		int maxn = Integer.MIN_VALUE, right = -1;
		int minn = Integer.MAX_VALUE, left = -1;
		for (int i = 0; i < n; i++) {
			if (maxn > nums[i]) {
				right = i;
			} else {
				maxn = nums[i];
			}
			if (minn < nums[n - i - 1]) {
				left = n - i - 1;
			} else {
				minn = nums[n - i - 1];
			}
		}
		return right == -1 ? 0 : right - left + 1;
	}
}
