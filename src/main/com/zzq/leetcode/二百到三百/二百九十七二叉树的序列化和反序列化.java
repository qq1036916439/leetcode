package com.zzq.leetcode.二百到三百;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.zzq.leetcode.base.TreeNode;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-10-29
 */
public class 二百九十七二叉树的序列化和反序列化 {

    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    public String reserialize(TreeNode root, String str) {
        if (root == null) {
            return str + "#,";
        }
        str += root.val + ",";
        str = reserialize(root.left, str);
        str = reserialize(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {
        return rdeserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("#")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }
}
