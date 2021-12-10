package com.zzq.leetcode.剑指offer;

import com.zzq.leetcode.base.ListNode;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-12-10
 */
public class 剑指offer重排序链表 {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode rec = rever(next);
        merge(head, rec);
    }

    public void merge(ListNode node1, ListNode node2) {
        while (node1 != null && node2 != null) {
            ListNode ntmp1 = node1.next;
            ListNode ntmp2 = node2.next;
            node1.next = node2;
            node1 = ntmp1;
            node2.next = node1;
            node2 = ntmp2;
        }
    }


    public ListNode rever(ListNode rev) {
        ListNode pre = null;
        while (rev != null) {
            ListNode node = rev.next;
            rev.next = pre;
            pre = rev;
            rev = node;
        }
        return pre;
    }

    public ListNode findMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
