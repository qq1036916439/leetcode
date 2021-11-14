package com.zzq.leetcode.六百到七百;

import java.util.HashMap;

public class 六百七十七键值映射 {
	class TreeNode {
		public TreeNode[] next =new TreeNode[26];
		public int val;
	}
	TreeNode root;

	HashMap<String,Integer> map=new HashMap();

	/** Initialize your data structure here. */
	public 六百七十七键值映射() {
		root=new TreeNode();
		map=new HashMap();
	}

	public void insert(String key, int val) {
		int k =val-map.getOrDefault(key,0);
		map.put(key,val);
		char[] array=key.toCharArray();
		TreeNode curNode=root;
		for(int i=0;i<array.length;i++){
			if(curNode.next[array[i]-'a']==null){
				curNode.next[array[i]-'a']=new TreeNode();
				curNode.next[array[i]-'a'].val=k;
			}else{
				curNode.next[array[i]-'a'].val+=k;
			}
			curNode=curNode.next[array[i]-'a'];
		}
	}

	public int sum(String prefix) {
		int result=0;
		char[] array=prefix.toCharArray();
		TreeNode cur=root;
		for(int i=0;i<array.length;i++){
			if(cur.next[array[i]-'a']==null){
				return 0;
			}
			cur=cur.next[array[i]-'a'];
		}
		return cur.val;
	}
}
