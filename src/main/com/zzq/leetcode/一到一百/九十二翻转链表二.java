package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

/**
 * @author zhangzhiqiang
 * @date 2021-03-21 1:00 上午
 */
public class 九十二翻转链表二 {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode hair = new ListNode(0);
    ListNode pre = hair;
    hair.next = head;
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }
    ListNode start = pre.next;
    ListNode end = start;
    for (int i = left; i < right; i++) {
      end = end.next;
    }
    ListNode next = end.next;
    ListNode[] myreverse = myreverse(start, end);
    start = myreverse[0];
    end = myreverse[1];
    pre.next = start;
    end.next = next;
    return hair.next;
  }

  public ListNode[] myreverse(ListNode head, ListNode tail) {
    ListNode pre = null;
    ListNode p = head;
    while (tail != pre) {
      ListNode next = p.next;
      p.next = pre;
      pre = p;
      p = next;
    }
    return new ListNode[]{tail, head};
  }
}
