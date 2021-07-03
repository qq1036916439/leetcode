package com.zzq.leetcode.一到一百;

public class 三十五搜索插入位置 {
	/**
	 *  左侧边界插入位置
	 */
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
