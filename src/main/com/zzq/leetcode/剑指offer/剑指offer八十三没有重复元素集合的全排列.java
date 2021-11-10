package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 剑指offer八十三没有重复元素集合的全排列 {
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> permute(int[] nums) {
		dfs(nums, 0, new LinkedList<>());
		return res;
	}

	public void dfs(int[] nums, int index, LinkedList<Integer> list) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!list.contains(nums[i])) {
				list.add(nums[i]);
				dfs(nums, i, list);
				list.removeLast();
			}
		}
	}
}
