package com.zzq.leetcode.七百到八百;

public class 七百零四二分查找 {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
