package com.zzq.leetcode.四百到五百;

import com.zzq.leetcode.base.TreeNode;

public class 四百五十删除二叉搜索树中的节点 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		}
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		}
		if (root.val == key) {
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			TreeNode node = root.right;
			while (node.left != null) {
				node = node.left;
			}
			node.left = root.left;
			root = root.right;
		}
		return root;
	}

}
