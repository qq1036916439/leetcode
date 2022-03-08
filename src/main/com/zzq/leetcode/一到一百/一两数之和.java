package com.zzq.leetcode.一到一百;

import java.util.HashMap;

/**
 * @author zhangzhiqiang
 */
public class 一两数之和 {
	/**
	 * 直接hash法O(n)
	 */
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			Integer index = map.get((target - nums[i]));
			if (index != null && index != i) {
				return new int[]{i, index};
			}
		}
		return new int[0];
	}
}
