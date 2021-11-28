package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-03-24 1:04 下午
 */
public class 七十五颜色分类 {

	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		for (int i = 0; i <= right; i++) {
			if (nums[i] == 0) {
				swap(nums, i, left);
				left++;
			}
			if (nums[i] == 2) {
				swap(nums, i, right);
				right--;
				i--;
			}
		}
	}

	public void swap(int[] swap, int i, int j) {
		int l = swap[i];
		swap[i] = swap[j];
		swap[j] = l;
	}
}
