package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.ListNode;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-11-02
 */
public class 二百三十七删除连表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
