package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 剑指offer八十五生成匹配的括号 {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<>();
		dfs(result, new LinkedList<>(), n, 0, 0);
		return result;
	}

	public void dfs(List<String> result, LinkedList<String> path, int n, int left, int right) {
		if (path.size() == 2 * n) {
			result.add(path.stream().collect(Collectors.joining("")));
			return;
		}
		if (left < n) {
			path.add("(");
			dfs(result, path, n, left + 1, right);
			path.removeLast();
		}
		if (right < left) {
			path.add(")");
			dfs(result, path, n, left, right + 1);
			path.removeLast();
		}
	}
}
