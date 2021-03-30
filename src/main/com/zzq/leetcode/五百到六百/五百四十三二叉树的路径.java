package com.zzq.leetcode.五百到六百;

import com.zzq.leetcode.base.TreeNode;

public class 五百四十三二叉树的路径 {
	int res = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return res;
	}

	//求高度
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		res = Math.max(res, left + right);
		return Math.max(left, right) + 1;
	}
}
