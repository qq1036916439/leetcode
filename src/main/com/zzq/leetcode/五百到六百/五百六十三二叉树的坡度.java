package com.zzq.leetcode.五百到六百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-11-18
 */
public class 五百六十三二叉树的坡度 {
	public int res = 0;

	public int findTilt(TreeNode root) {
		dfs(root);
		return res;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		res = res + Math.abs(left - right);
		return root.val + left + right;
	}
}
