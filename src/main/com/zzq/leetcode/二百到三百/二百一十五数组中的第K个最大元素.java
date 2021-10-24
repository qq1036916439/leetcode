package com.zzq.leetcode.二百到三百;

import java.util.Random;

public class 二百一十五数组中的第K个最大元素 {
	public int findKthLargest(int[] nums, int k) {
		return randomQuickSort(nums, 0, nums.length - 1, nums.length - k);
	}


	public int randomQuickSort(int[] nums, int l, int r, int index) {
		int pos = randomPartation(nums, l, r);
		if (pos == index) {
			return nums[pos];
		} else {
			return pos < index ? randomQuickSort(nums, pos + 1, r, index) : randomQuickSort(nums, l, pos - 1, index);
		}
	}

	public int randomPartation(int[] nums, int left, int right) {
		int i = new Random().nextInt(right - left + 1) + left;
		swap(nums, right, i);
		return partation(nums, left, right);
	}

	public int partation(int[] nums, int left, int right) {
		int p = nums[right];
		int i = left - 1;
		for (int j = left; j <= right - 1; j++) {
			if (nums[j] <= p) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, right);
		return i + 1;
	}

	public void swap(int[] swap, int l, int r) {
		int tem = swap[l];
		swap[l] = swap[r];
		swap[r] = tem;
	}
}
