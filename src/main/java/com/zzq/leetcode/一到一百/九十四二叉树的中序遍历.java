package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 九十四二叉树的中序遍历 {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root=root.left;
			}
			if(!stack.isEmpty()){
				root = stack.pop();
				if(root!=null){
					res.add(root.val);
				}
				root=root.right;
			}
		}
		return res;
	}
}
