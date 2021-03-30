package com.zzq.leetcode.一到一百;

public class 五最长回文子串 {
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return s;
		}
		char[] chars = s.toCharArray();
		String res = s.substring(0, 1);
		int max = 0;
		for (int i = 0; i < chars.length; i++) {
			String s1 = find(s, i, i + 1);
			String s2 = find(s, i, i);
			if (max < s1.length()) {
				max = s1.length();
				res = s1;
			}
			if (max < s2.length()) {
				max = s2.length();
				res = s2;
			}

		}
		return res;
	}

	public String find(String str, int left, int right) {
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		return str.substring(left + 1, right);
	}
}
