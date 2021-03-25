package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang
 * @date 2021-03-25 6:52 下午
 */
public class 一百零四二叉树的最大深度 {

  public int maxDepth(TreeNode root) {
    return maxDepth(root, 0);
  }

  public int maxDepth(TreeNode root, int depth) {
    if (root == null) {
      return depth;
    }
    return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
  }
}
