package com.zzq.leetcode.base;

public class TreeUtile {
	static int index = 0;

	public static TreeNode buildTree(Integer[] nodes, int index) {
		if(index>nodes.length-1){
			return null;
		}
		if(nodes[index]==null){
			return null;
		}
		TreeNode treeNode = new TreeNode(nodes[index]);
		treeNode.left = buildTree(nodes, index * 2 + 1);
		treeNode.right = buildTree(nodes, index * 2 + 2);
		return treeNode;
	}


}
