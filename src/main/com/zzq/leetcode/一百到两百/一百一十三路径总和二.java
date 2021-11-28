package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-21 1:23 上午
 */
public class 一百一十三路径总和二 {

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		LinkedList<Integer> path = new LinkedList<>();
		dfs(root, path, targetSum);
		return res;
	}

	public void dfs(TreeNode root, LinkedList<Integer> path, int sum) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		sum -= root.val;
		if (root.left == null && root.right == null && sum == 0) {
			res.add(new ArrayList<>(path));
		}
		dfs(root.left, path, sum);
		dfs(root.right, path, sum);
		path.removeLast();
	}
}
