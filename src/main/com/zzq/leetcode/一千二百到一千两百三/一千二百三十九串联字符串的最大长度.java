package com.zzq.leetcode.一千二百到一千两百三;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 一千二百三十九串联字符串的最大长度 {
	StringBuilder sb = new StringBuilder();
	int res = 0;

	public int maxLength(List<String> arr) {
		dfs(arr, 0);
		return res;
	}

	public void dfs(List<String> arr, int start) {
		char[] ch = sb.toString().toCharArray();
		Set<Character> set = new HashSet<>();
		for (char c : ch) {
			if (set.contains(c)) {
				return;
			} else {
				set.add(c);
			}
		}
		res = Math.max(res, sb.length());
		for (int i = start; i < arr.size(); i++) {
			sb.append(arr.get(i));
			dfs(arr, i + 1);
			sb.delete(sb.length() - arr.get(i).length(), sb.length());
		}
	}
}
