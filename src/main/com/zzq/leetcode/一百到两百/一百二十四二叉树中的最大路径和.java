package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

public class 一百二十四二叉树中的最大路径和 {
	public int res=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return res;
	}
	public int maxGain(TreeNode node){
		if(node==null){
			return 0;
		}
		int left = Math.max(maxGain(node.left), 0);
		int right =Math.max(maxGain(node.right),0);
		int preice=node.val+left+right;
		res=Math.max(res,preice);
		return Math.max(left,right)+node.val;
	}
}
