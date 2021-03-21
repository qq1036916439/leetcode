package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 十九删除链表的单数第N个节点 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode end = pre;
		ListNode start = pre;
		for (int i = 0; i < n; i++) {
			start = start.next;
		}
		while (start.next != null) {
			start = start.next;
			end = end.next;
		}
		end.next = end.next.next;
		return pre.next;
	}
}
