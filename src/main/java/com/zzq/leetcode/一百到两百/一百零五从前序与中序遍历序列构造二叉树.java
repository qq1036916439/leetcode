package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.TreeNode;

import java.util.HashMap;

/**
 * @author zhangzhiqiang
 * @date 2021-03-25 7:41 下午
 */
public class 一百零五从前序与中序遍历序列构造二叉树 {

  public HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inoStart, int inoEnd) {
    if (preStart > preEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    Integer inoIndex = map.get(preorder[preStart]);
    int length = inoIndex - inoStart;
    root.left = buildTree(preorder, preStart + 1, preStart + length, inorder, inoStart, inoIndex - 1);
    root.right = buildTree(preorder, preStart + length + 1, preEnd, inorder, inoIndex + 1, inoEnd);
    return root;
  }
}
