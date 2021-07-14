package com.zzq.leetcode.一百到两百;

public class 一百六十七两数之和输入有序数组 {
	public int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int target1 = findTarget(numbers, i + 1, numbers.length - 1, target - numbers[i]);
			if (target1 == -1) {
				continue;
			} else {
				return new int[]{i + 1, target1 + 1};
			}
		}
		return new int[]{-1, -1};
	}

	public int findTarget(int[] numbers, int left, int right, int target) {
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (numbers[mid] == target) {
				return mid;
			}
			if (numbers[mid] > target) {
				right = mid - 1;
			}
			if (numbers[mid] < target) {
				left = mid + 1;
			}
		}
		return -1;
	}
}
