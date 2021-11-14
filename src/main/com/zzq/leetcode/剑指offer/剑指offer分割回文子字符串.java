package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 剑指offer分割回文子字符串 {
	public String[][] partition(String s) {
		List<List<String>> res = new ArrayList<>();
		back(new LinkedList<>(), s, 0, s.length(), res);
		int size = res.size();
		String[][] strings = new String[size][];
		for (int j = 0; j < size; j++) {
			String[] str = new String[res.get(j).size()];
			for (int i = 0; i < res.get(j).size(); i++) {
				str[i] = res.get(j).get(i);
			}
			strings[j] = str;
		}
		return strings;
	}

	public void back(LinkedList<String> path, String s, int start, int len, List<List<String>> res) {
		if (start == len) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i < len; i++) {
			if (!check(s, start, i)) {
				continue;
			}
			path.add(s.substring(start, i + 1));
			back(path, s, i + 1, len, res);
			path.removeLast();
		}
	}

	public boolean check(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
