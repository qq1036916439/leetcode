package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang
 * @date 2021-07-13 1:40 下午
 */
public class 一百相同的树 {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
