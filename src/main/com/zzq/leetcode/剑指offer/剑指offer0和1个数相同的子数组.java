package com.zzq.leetcode.剑指offer;

import java.util.HashMap;

public class 剑指offer0和1个数相同的子数组 {
	public int findMaxLength(int[] nums) {
		int counter = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				counter++;
			} else {
				counter--;
			}
			if (map.containsKey(counter)) {
				res = Math.max(i - map.get(counter), res);
			} else {
				map.put(counter, i);
			}
		}
		return res;
	}
}
