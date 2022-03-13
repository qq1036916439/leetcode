package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.TreeNode;

public class 九十九恢复二叉搜索树 {
	TreeNode[] nodes = new TreeNode[2];
	TreeNode pre = null;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		bfs(root);
		int tem = nodes[0].val;
		nodes[0].val = nodes[1].val;
		nodes[1].val = tem;
	}

	void bfs(TreeNode node) {
		if (node == null) {
			return;
		}
		bfs(node.left);
		if (pre != null) {
			if (pre.val > node.val) {
				nodes[0] = nodes[0] == null ? pre : nodes[0];
				nodes[1] = node;
			}
		}
		pre = node;
		bfs(node.right);
	}
}
