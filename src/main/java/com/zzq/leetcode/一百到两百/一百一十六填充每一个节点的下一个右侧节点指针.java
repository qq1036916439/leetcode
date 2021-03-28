package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.Node;

public class 一百一十六填充每一个节点的下一个右侧节点指针 {
	public Node connect(Node root) {
		if (root == null || root.right == null) {
			return root;
		}
		root.left.next = root.right;
		root.right.next = root.next == null ? null : root.next.left;
		connect(root.left);
		connect(root.right);
		return root;
	}
}
