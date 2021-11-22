package com.zzq.leetcode.剑指offer;

public class 剑指offer字符串中的变位词 {
	public boolean checkInclusion(String s1, String s2) {
		int left = 0;
		int right = 0;
		char[] chars1 = s1.toCharArray();
		int[] needs = new int[128];
		int[] window = new int[128];
		int needCound = 0;
		for (int i = 0; i < chars1.length; i++) {
			if (needs[chars1[i]] == 0) {
				needCound++;
			}
			needs[chars1[i]]++;
		}
		int windos = 0;
		char[] chars = s2.toCharArray();
		while (right < chars.length) {
			char a = chars[right];
			window[a]++;
			if (window[a] == needs[a]) {
				windos++;
			}
			right++;
			while (needCound == windos && left < right) {
				char b = chars[left];
				if (window[b] == needs[b]) {
					windos--;
				}
				left++;
				window[b]--;
				if (right - left + 1 == s1.length()) {
					return true;
				}
			}
		}
		return false;
	}
}
