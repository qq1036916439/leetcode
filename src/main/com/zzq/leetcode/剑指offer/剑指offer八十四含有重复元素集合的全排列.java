package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 剑指offer八十四含有重复元素集合的全排列 {
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		dfs(nums, 0, new LinkedList<>(), used);
		return res;
	}

	public void dfs(int[] nums, int index, LinkedList<Integer> list, boolean[] used) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && used[i - 1] && nums[i] == nums[i - 1]) {
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, i, list, used);
			list.removeLast();
			used[i] = false;
		}
	}
}
