package com.zzq.leetcode.一到一百;

public class 三最长无重复子串 {
	public int lengthOfLongestSubstring(String s) {
		int[] window = new int[128];
		char[] array = s.toCharArray();
		int res = 0;
		int length = 0;
		int left = 0;
		int right = 0;
		while (right < array.length) {
			char c = array[right];
			window[c]++;
			right++;
			while (window[c] == 2) {
				char k = array[left];
				window[k]--;
				left++;
			}
			res = Math.max(res, right - left);
		}
		return res;
	}
}
