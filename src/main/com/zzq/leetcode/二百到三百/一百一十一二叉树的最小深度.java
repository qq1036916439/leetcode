package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang
 * @date 2021-07-13 1:45 下午
 */
public class 一百一十一二叉树的最小深度 {

  int min = Integer.MAX_VALUE;

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    minDepth(root, 1);
    return min;
  }

  public void minDepth(TreeNode root, int path) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      min = Math.min(min, path);
    }
    minDepth(root.left, path + 1);
    minDepth(root.right, path + 1);
  }
}
