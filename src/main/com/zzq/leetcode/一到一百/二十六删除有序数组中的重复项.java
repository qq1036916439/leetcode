package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-04-06 1:19 下午
 */
public class 二十六删除有序数组中的重复项 {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
