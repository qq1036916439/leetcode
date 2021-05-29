package com.zzq.leetcode.五百到六百;

import java.util.HashMap;

public class 五百六十和为K的子数组 {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int presum = 0;
		int result = 0;
		for (int num : nums) {
			presum += num;
			result += map.getOrDefault(presum - k, 0);
			map.put(presum, map.getOrDefault(presum, 0) + 1);
		}
		return result;
	}
}
