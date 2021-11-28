package com.zzq.leetcode.剑指offer;

import com.zzq.leetcode.base.TreeNode;

public class 二叉树的镜像 {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		mirrorTree(root.left);
		mirrorTree(root.right);
		return root;
	}
}
