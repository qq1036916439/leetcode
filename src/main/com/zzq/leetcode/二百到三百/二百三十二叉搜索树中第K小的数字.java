package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.TreeNode;

public class 二百三十二叉搜索树中第K小的数字 {
	int res = 0;
	int k = 0;

	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	public void dfs(TreeNode treeNode) {
		if (treeNode == null || k == 0) {
			return;
		}
		dfs(treeNode.left);
		k--;
		if (k == 0) {
			res = treeNode.val;
		}
		dfs(treeNode.right);
	}
}
