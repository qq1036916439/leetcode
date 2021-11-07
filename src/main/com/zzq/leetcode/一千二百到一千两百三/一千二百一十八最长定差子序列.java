package com.zzq.leetcode.一千二百到一千两百三;

import java.util.HashMap;

public class 一千二百一十八最长定差子序列 {
	public int longestSubsequence(int[] arr, int difference) {
		HashMap<Integer, Integer> map = new HashMap();
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int di = map.getOrDefault(arr[i] - difference, 0) + 1;
			res = Math.max(res, di);
			map.put(arr[i], di);
		}
		return res;
	}
}
