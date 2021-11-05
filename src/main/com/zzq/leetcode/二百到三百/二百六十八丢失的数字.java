package com.zzq.leetcode.二百到三百;

public class 二百六十八丢失的数字 {
	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return (nums.length + 1) * nums.length / 2 - sum;
	}
}
