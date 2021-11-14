package com.zzq.leetcode.二百到三百;

public class 二百八十三实现前缀树 {

	public static class TreeNode {
		public TreeNode[] ne = new TreeNode[26];
		public boolean end;
	}

	public TreeNode root;

	public 二百八十三实现前缀树() {
		root = new TreeNode();
	}

	public void insert(String word) {
		char[] chars = word.toCharArray();
		TreeNode cur = root;
		for (int i = 0; i < chars.length; i++) {
			int u = (int) (chars[i] - 'a');
			if (cur.ne[u] == null) {
				cur.ne[u] = new TreeNode();
			}
			cur = cur.ne[u];
		}
		cur.end = true;
	}

	public boolean search(String word) {
		char[] chars = word.toCharArray();
		TreeNode cur = root;
		for (int i = 0; i < chars.length; i++) {
			int u = (int) (chars[i] - 'a');
			if (cur.ne[u] == null) {
				return false;
			} else {
				cur = cur.ne[u];
			}
		}
		return cur.end;
	}

	public boolean startsWith(String prefix) {
		char[] chars = prefix.toCharArray();
		TreeNode cur = root;
		for (int i = 0; i < chars.length; i++) {
			int u = (int) (chars[i] - 'a');
			if (cur.ne[u] == null) {
				return false;
			}
			cur = cur.ne[u];
		}
		return true;
	}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
