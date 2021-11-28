package com.zzq.leetcode.五百到六百;

import java.util.HashMap;

/**
 * @author zhangzhiqiang
 * @date 2021-06-03 3:23 下午
 */
public class 五百二十五连续数组 {
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int result = 0;
		int sum = 0;
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum++;
			} else {
				sum--;
			}
			if (map.containsKey(sum)) {
				result = Math.max(i - map.get(sum), result);
			} else {
				map.put(sum, i);
			}
		}
		return result;
	}
}
