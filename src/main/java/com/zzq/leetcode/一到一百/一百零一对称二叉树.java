package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.TreeNode;

public class 一百零一对称二叉树 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isisSymmetric(root.left, root.right);
	}

	public boolean isisSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val && isisSymmetric(left.left, right.right) && isisSymmetric(right.left, left.right);
	}
}
