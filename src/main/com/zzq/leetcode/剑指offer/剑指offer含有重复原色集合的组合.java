package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 剑指offer含有重复原色集合的组合 {

	List<List<Integer>> res = new ArrayList();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		dfs(candidates, new LinkedList<>(), 0, 0, target);
		return res;
	}

	public void dfs(int[] candidates, LinkedList<Integer> path, int index, int sum, int target) {
		if (sum == target) {
			res.add(new ArrayList<>(path));
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				return;
			}
			if (i > index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			path.add(candidates[i]);
			dfs(candidates, path, i + 1, sum + candidates[i], target);
			path.removeLast();
		}
	}
}
