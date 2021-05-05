package com.zzq.leetcode.周赛;

import java.util.HashMap;

public class 五千七百零八 {
	public int countNicePairs(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		long count = 0;
		HashMap<Integer, Long> reverseMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int reverse = reverse(nums[i]);
			count = (count + reverseMap.getOrDefault(nums[i] - reverse, 0L)) % 1000000007;
			reverseMap.put(nums[i] - reverse, reverseMap.getOrDefault(nums[i] - reverse, 0L) + 1);
		}

		return (int) count % Integer.MAX_VALUE;
	}

	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
