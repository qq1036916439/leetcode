package com.zzq.leetcode.九百到一千;

public class 九百一十二排序数组归并排序 {
	public int[] temp = null;

	public int[] sortArray(int[] nums) {
		if (nums.length == 0) {
			return nums;
		}
		temp = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}

	public void mergeSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) >> 1;
		mergeSort(nums, left, mid );
		mergeSort(nums, mid + 1, right);
		int i = left;
		int j = mid + 1;
		int index = 0;
		while (i <= mid && j <= right) {
			if (nums[i] <= nums[j]) {
				temp[index++] = nums[i++];
			} else {
				temp[index++] = nums[j++];
			}
		}
		while (i <= mid) {
			temp[index++] = nums[i++];
		}
		while (j <= right) {
			temp[index++] = nums[j++];
		}
		for (int k = 0; k < right - left + 1; ++k) {
			nums[k + left] = temp[k];
		}
	}
}
