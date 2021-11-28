package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 剑指offer字符串中所有的变位词 {
	public static List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> res = new ArrayList<>();
		char[] sarray = s.toCharArray();
		char[] parray = p.toCharArray();
		if (parray.length > s.length()) {
			return res;
		}
		int[] sw = new int[26];
		int[] pw = new int[26];
		for (char value : parray) {
			pw[value - 'a']++;
		}
		int right = 0;
		int left = 0;
		while (right < sarray.length) {
			char c = sarray[right];
			sw[c - 'a']++;
			while (sw[c - 'a'] > pw[c - 'a']) {
				char c1 = sarray[left];
				sw[c1 - 'a']--;
				left++;
			}
			if (right - left + 1 == p.length()) {
				res.add(left);
			}
			right++;
		}
		return res;
	}

	public static void main(String[] args) {
		findAnagrams("cbaebabacd", "abc");
	}
}
