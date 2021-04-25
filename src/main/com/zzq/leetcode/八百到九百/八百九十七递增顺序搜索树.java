package com.zzq.leetcode.八百到九百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang
 * @date 2021-04-25 1:11 下午
 */
public class 八百九十七递增顺序搜索树 {

  public TreeNode res = null;
  public TreeNode pre = null;

  public TreeNode increasingBST(TreeNode root) {
    dfs(root);
    return res;
  }

  public void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    node.left = null;
    if (res == null) {
      res = node;
    }
    if (pre != null) {
      pre.left = null;
      pre.right = node;
    }
    pre = node;
    dfs(node.right);
  }
}
