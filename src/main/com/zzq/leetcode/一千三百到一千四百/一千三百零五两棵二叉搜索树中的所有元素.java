package com.zzq.leetcode.一千三百到一千四百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 一千三百零五两棵二叉搜索树中的所有元素 {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		dfs(root1, list1);
		dfs(root2, list2);
		List<Integer> result = new ArrayList();
		int p1 = 0;
		int p2 = 0;
		while (true) {
			if (p1 == list1.size()) {
				result.addAll(list2.subList(p2, list2.size()));
				break;
			}
			if (p2 == list2.size()) {
				result.addAll(list1.subList(p1, list1.size()));
				break;
			}
			if (list1.get(p1) < list2.get(p2)) {
				result.add(list1.get(p1++));
			} else {
				result.add(list2.get(p2++));
			}
		}
		return result;
	}

	public void dfs(TreeNode root, List<Integer> list) {
		if (root != null) {
			dfs(root.left, list);
			list.add(root.val);
			dfs(root.right, list);
		}
	}
}
