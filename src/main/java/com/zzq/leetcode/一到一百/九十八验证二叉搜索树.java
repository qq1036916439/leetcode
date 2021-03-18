package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.TreeNode;

public class 九十八验证二叉搜索树 {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long low, long hight) {
		if (root == null) {
			return true;
		}
		if (root.val <= low || root.val >= hight) {
			return false;
		}
		return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, hight);
	}
}
