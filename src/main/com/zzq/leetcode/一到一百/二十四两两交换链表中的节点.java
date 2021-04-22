package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;
import com.zzq.leetcode.base.ListNodeFunction;

/**
 * @author zhangzhiqiang
 * @date 2021-04-21 1:52 下午
 */
public class 二十四两两交换链表中的节点 {

  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode temp = new ListNode();
    temp.next = head;
    ListNode pre = temp;
    while (pre.next != null && pre.next.next != null) {
      ListNode o = pre.next;
      ListNode t = o.next;
      o.next=t.next;
      t.next=o;
      pre.next=t;
      pre=o;
    }
    return temp.next;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeFunction.arrayToListNode(1, 2, 3, 4,5);
    ListNode listNode1 = swapPairs(listNode);
    ListNodeFunction.printListNode(listNode1);
  }
}
