package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 剑指offer八十一允许重复选择元素 {
	List<List<Integer>> res = new ArrayList();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		LinkedList<Integer> path = new LinkedList<>();
		dfs(candidates, path, 0, 0, target);
		return res;
	}

	public void dfs(int[] candidates, LinkedList<Integer> path, int index, int sum, int target) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			path.add(candidates[i]);
			dfs(candidates, path, i, sum + candidates[i], target);
			path.remove(path.size() - 1);
		}
	}
}
