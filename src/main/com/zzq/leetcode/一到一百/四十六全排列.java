package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 四十六全排列 {
	public List<List<Integer>> permute(int[] nums) {
		LinkedList<Integer> path = new LinkedList<>();
		LinkedList<List<Integer>> res = new LinkedList<>();
		boolean[] used = new boolean[nums.length];
		back(nums, path, 0, res, used);
		return res;
	}

	public void back(int[] nums, LinkedList<Integer> path, int index, LinkedList<List<Integer>> res, boolean[] used) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			path.add(nums[i]);
			back(nums, path, index + 1, res, used);
			path.removeLast();
			used[i] = false;
		}
	}
}
