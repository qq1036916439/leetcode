package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 十九删除链表的单数第N个节点 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
