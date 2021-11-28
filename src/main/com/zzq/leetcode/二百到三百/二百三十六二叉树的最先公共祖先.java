package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang
 * @date 2021-03-25 1:21 下午
 */
public class 二百三十六二叉树的最先公共祖先 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}
}
