package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-03-24 1:04 下午
 */
public class 七十五颜色分类 {

	/**
	 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
	 *
	 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
	 *
	 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
	 * https://leetcode-cn.com/problems/sort-colors/
	 * 0 1 2
	 */
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
