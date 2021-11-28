package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-04-06 1:27 下午
 */
public class 八十删除有序数组中的重复项 {

	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n <= 2) {
			return n;
		}
		int slow = 2;
		int fast = 2;
		while (fast < n) {
			if (nums[slow - 2] < nums[fast]) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}
}
