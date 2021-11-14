package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 剑指offer数组中和为0的三个数 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if (sum < 0) {
					left++;
				}
				if (sum > 0) {
					right--;
				}
				if (sum == 0) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					result.add(list);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				}
			}
		}
		return result;
	}
}
