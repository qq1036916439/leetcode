package com.zzq.leetcode.八百到九百;

import com.zzq.leetcode.base.TreeNode;
import com.zzq.leetcode.base.TreeUtile;

import java.util.ArrayList;
import java.util.Stack;

public class 八百九十七 {
	public static TreeNode increasingBST(TreeNode root) {
		if(root==null){
			return null;
		}
		Stack<TreeNode> stack =new Stack();
		ArrayList<TreeNode> nodes =new ArrayList();
		TreeNode node=root;
		while(!stack.isEmpty()||node!=null){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(!stack.isEmpty()){
				node=stack.pop();
				nodes.add(node);
				node=node.right;
			}
		}
		for(int i=0;i<nodes.size()-1;i++){
			nodes.get(i).right=nodes.get(i+1);
			nodes.get(i).left=null;
		}
		return nodes.get(0);
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeUtile.buildTree(new Integer[]{2,1,3,4}, 0);
		TreeNode treeNode1 = increasingBST(treeNode);

	}
}
