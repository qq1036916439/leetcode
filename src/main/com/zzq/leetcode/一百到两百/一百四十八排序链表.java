package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.ListNode;

/**
 * @author zhangzhiqiang
 * @date 2021-03-31 1:01 下午
 */
public class 一百四十八排序链表 {
  public ListNode sortList(ListNode head) {
    // 1、递归结束条件
    if (head == null || head.next == null) {
      return head;
    }

    // 2、找到链表中间节点并断开链表 & 递归下探
    ListNode midNode = middleNode(head);
    ListNode rightHead = midNode.next;
    midNode.next = null;

    ListNode left = sortList(head);
    ListNode right = sortList(rightHead);

    // 3、当前层业务操作（合并有序链表）
    return mergeTwoLists(left, right);
  }

  //  找到链表中间节点（876. 链表的中间结点）
  private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // 合并两个有序链表（21. 合并两个有序链表）
  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode sentry = new ListNode(-1);
    ListNode curr = sentry;

    while(l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }

      curr = curr.next;
    }

    curr.next = l1 != null ? l1 : l2;
    return sentry.next;
  }
}
