package com.zzq.leetcode.六百到七百;

import java.util.Arrays;
import java.util.HashMap;

public class 六百四十五错误的集合 {
	public int[] findErrorNums(int[] nums) {
		Arrays.sort(nums);
		int pre=0;
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (pre == nums[i]) {
				result[0] = pre;
			}
			if (nums[i] - pre > 1) {
				result[1] = pre + 1;
			}
			pre = nums[i];
		}
		if (nums[nums.length - 1] != nums.length) {
			result[1] = nums.length;
		}
		return result;
	}

	public int[] findErrorNums2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer orDefault = map.getOrDefault(nums[i], 0);
			map.put(nums[i], ++orDefault);
		}
		int[] result = new int[2];
		for (int i = 1; i <= nums.length; i++) {
			Integer orDefault = map.getOrDefault(i, 0);
			if (orDefault == 0) {
				result[1] = i;
			}
			if (orDefault == 2) {
				result[0] = i;
			}
		}
		return result;
	}
}
