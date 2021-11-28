package com.zzq.leetcode.一百到两百;

import java.util.HashSet;
import java.util.Set;

public class 一百二十八最长连续序列 {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet();
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i] - 1)) {
				int curNum = nums[i];
				int length = 0;
				while (set.contains(curNum)) {
					curNum++;
					length++;
				}
				res = Math.max(length, res);
			}
		}
		return res;
	}
}
