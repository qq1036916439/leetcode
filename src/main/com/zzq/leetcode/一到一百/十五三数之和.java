package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 十五三数之和 {
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3) {
			return res;
		}
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					while (j < k && nums[j] == nums[++j]) ;
				}
				if (sum > 0) {
					while (j < k && nums[k] == nums[--k]) ;
				}

				if (sum == 0) {
					res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
					while (j < k && nums[j] == nums[++j]) ;
					while (j < k && nums[k] == nums[--k]) ;
				}
			}
		}
		return res;
	}
}
