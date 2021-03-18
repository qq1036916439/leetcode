package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 一百四十四二叉树的前序遍历 {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode pop = stack.pop();
			if (pop == null) {
				continue;
			}
			res.add(pop.val);
			if (pop.right != null) {
				stack.push(pop.right);
			}
			if (pop.left != null) {
				stack.push(pop.left);
			}
		}
		return res;
	}
}
