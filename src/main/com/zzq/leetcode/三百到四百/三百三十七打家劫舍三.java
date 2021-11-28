package com.zzq.leetcode.三百到四百;

import com.zzq.leetcode.base.TreeNode;

public class 三百三十七打家劫舍三 {
	public int rob(TreeNode root) {
		int[] result = robInternal(root);
		return Math.max(result[0], result[1]);
	}

	public int[] robInternal(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		int[] result = new int[2];
		int[] left = robInternal(root.left);
		int[] right = robInternal(root.right);
		//0 代表不偷。1代表偷。
		result[0] = Math.max(left[0], left[1] + Math.max(right[0], right[1]));
		result[1] = left[0] + right[0] + root.val;
		return result;
	}
}
