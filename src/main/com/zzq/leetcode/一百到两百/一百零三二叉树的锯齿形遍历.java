package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-25 1:25 下午
 */
public class 一百零三二叉树的锯齿形遍历 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean falg = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (falg) {
					list.addFirst(poll.val);
				} else {
					list.addLast(poll.val);
				}
				if (poll.left != null) {
					queue.addLast(poll.left);
				}
				if (poll.right != null) {
					queue.addLast(poll.right);
				}
			}
			res.add(list);
			falg = !falg;
		}
		return res;
	}
}
