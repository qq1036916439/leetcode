package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-25 1:06 下午
 */
public class 一百零二二叉树的层序遍历 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				list.add(poll.val);
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
			res.add(list);
		}
		return res;
	}
}
