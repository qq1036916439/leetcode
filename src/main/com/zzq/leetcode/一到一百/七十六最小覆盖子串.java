package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-03-19 6:44 下午
 */
public class 七十六最小覆盖子串 {

	public static String minWindow(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		int[] needs = new int[128];
		int[] window = new int[128];
		int count = 0;
		int valid = 0;
		String res = "";
		int maxLength = Integer.MAX_VALUE;
		for (int i = 0; i < tArray.length; i++) {
			needs[tArray[i]]++;
			if (needs[tArray[i]] == 1) {
				valid++;
			}
		}
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			char c = sArray[right];
			right++;
			window[c]++;
			if (window[c] == needs[c]) {
				count++;
			}
			while (count == valid) {
				if (valid == count && maxLength > right - left) {
					res = s.substring(left, right);
					maxLength = right - left;
				}
				char k = sArray[left];
				if (window[k] == needs[k]) {
					count--;
				}
				left++;
				window[k]--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
