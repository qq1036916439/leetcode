package com.zzq.leetcode.剑指offer;

import com.zzq.leetcode.base.Node;

public class 三十六二叉搜索树与双向链表 {
	public Node head = null;
	public Node pre = null;

	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		mid(root);
		head.left = pre;
		pre.right = head;
		return head;
	}

	public void mid(Node root) {
		if (root == null) {
			return;
		}
		mid(root.left);
		if (pre != null) {
			pre.right = root;
			root.left = pre;
		}
		pre = root;
		if (head == null) {
			head = root;
		}
		mid(root.right);
	}
}
