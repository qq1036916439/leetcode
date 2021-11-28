package com.zzq.leetcode.四百到五百;

import java.util.ArrayList;
import java.util.List;

public class 四百三十八找到字符串中所有字母异位词 {
	public List<Integer> findAnagrams(String s, String p) {
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
		int rigth = 0;
		int left = 0;
		while (rigth < sarray.length) {
			char c = sarray[rigth];
			sw[c - 'a']++;
			rigth++;
			while (sw[c - 'a'] > pw[c - 'a']) {
				char c1 = sarray[left];
				sw[c1 - 'a']--;
				left++;
			}
			if (rigth - left + 1 == p.length()) {
				res.add(left);
			}
		}
		return res;
	}
}
