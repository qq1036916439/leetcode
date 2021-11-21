package com.zzq.leetcode.五百到六百;

import com.zzq.leetcode.base.Node;

import java.util.List;

public class N叉数的最大深度 {
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return maxDepth(root, 1);
	}

	public int maxDepth(Node root, int k) {
		List<Node> children = root.children;
		if (children == null || children.size() == 0) {
			return k;
		}
		int res = 0;
		for (int i = 0; i < children.size(); i++) {
			res = Math.max(maxDepth(children.get(i), k + 1), res);
		}
		return res;
	}
}

