package com.zzq.leetcode.八百到九百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 八百六十三二叉树重所有距离为K的节点 {

	HashMap<Integer, TreeNode> map = new HashMap();
	List<Integer> ans = new ArrayList();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		findParent(root);
		finAns(target, null, 0, k);
		return ans;
	}

	public void findParent(TreeNode root) {
		if (root.left != null) {
			map.put(root.left.val, root);
			findParent(root.left);
		}
		if (root.right != null) {
			map.put(root.right.val, root);
			findParent(root.right);
		}
	}

	public void finAns(TreeNode node, TreeNode from, int depth, int k) {
		if (node == null) {
			return;
		}
		if (depth == k) {
			ans.add(node.val);
			return;
		}
		if (node.left != from) {
			finAns(node.left, node, depth + 1, k);
		}
		if (node.right != from) {
			finAns(node.right, node, depth + 1, k);
		}
		if (map.get(node.val) != from) {
			finAns(map.get(node.val), node, depth + 1, k);
		}
	}
}
