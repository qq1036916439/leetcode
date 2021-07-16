package com.zzq.leetcode.七百到八百;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang
 * @date 2021-07-16 6:08 下午
 */
public class 七百二叉搜索树中的搜索 {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    if (root.val < val) {
      return searchBST(root.right, val);
    }
    return searchBST(root.left, val);
  }
}
