package com.zzq.leetcode.八百到九百;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2022-04-20
 */
public class 八百六十三二叉树中所有距离为K的结点 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, parentMap);
        findAns(null, target, parentMap, res, k);
        return res;
    }

    public void findAns(TreeNode from, TreeNode node, HashMap<TreeNode, TreeNode> parentMap, List<Integer> res,
            int count) {
        if (node == null) {
            return;
        }
        if (count == 0) {
            res.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node, node.left, parentMap, res, count - 1);
        }
        if (node.right != from) {
            findAns(node, node.right, parentMap, res, count - 1);
        }
        if (parentMap.get(node) != from) {
            findAns(node, parentMap.get(node), parentMap, res, count - 1);
        }
    }

    public void dfs(TreeNode node, HashMap<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
            dfs(node.left, parentMap);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            dfs(node.right, parentMap);
        }
    }
}
