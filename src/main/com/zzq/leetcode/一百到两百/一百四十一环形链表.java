package com.zzq.leetcode.一百到两百;

import com.zzq.leetcode.base.ListNode;

/**
 * @author zhangzhiqiang
 * @date 2021-03-29 12:56 下午
 */
public class 一百四十一环形链表 {

  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (slow != null && fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
