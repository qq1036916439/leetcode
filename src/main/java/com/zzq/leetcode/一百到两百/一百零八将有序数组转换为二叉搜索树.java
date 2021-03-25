package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

public class 一百零八将有序数组转换为二叉搜索树 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return buildTree(nums, 0, nums.length - 1);
	}

	public TreeNode buildTree(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, left, mid - 1);
		root.right = buildTree(nums, mid + 1, right);
		return root;
	}
}
