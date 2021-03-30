package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 九十子集二 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		LinkedList<Integer> path = new LinkedList<>();
		boolean[] used = new boolean[nums.length];
		List<List<Integer>> res = new ArrayList<>();
		back(nums, 0, res, path, used);
		return res;
	}

	public void back(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> path, boolean[] used) {
		res.add(new ArrayList<>(path));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			path.add(nums[i]);
			back(nums, i + 1, res, path, used);
			path.removeLast();
		}
	}
}
