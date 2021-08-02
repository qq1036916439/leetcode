package com.zzq.leetcode.三百到四百;

import java.util.Random;

public class 三百八十四打乱数组 {
	public int[] nums = null;
	Random r = new Random();

	public 三百八十四打乱数组(int[] nums) {
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] result = nums.clone();
		for (int i = 0; i < result.length; i++) {
			int k = r.nextInt(result.length - i) + i;
			int s = result[k];
			result[k] = result[i];
			result[i] = s;
		}
		return result;
	}
}
