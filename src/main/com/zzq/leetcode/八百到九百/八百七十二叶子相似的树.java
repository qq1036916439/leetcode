package com.zzq.leetcode.八百到九百;

import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-05-10 6:47 下午
 */
public class 八百七十二叶子相似的树 {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> nums1 = new ArrayList();
    ArrayList<Integer> nums2 = new ArrayList();
    dfs(root1, nums1);
    dfs(root2, nums2);
    if (nums1.size() != nums2.size()) {
      return false;
    }
    for (int i = 0; i < nums1.size(); i++) {
      if (!nums1.get(i).equals(nums2.get(i))) {
        return false;
      }
    }
    return true;
  }

  private void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      list.add(root.val);
    }
    dfs(root.left, list);
    dfs(root.right, list);

  }
}
