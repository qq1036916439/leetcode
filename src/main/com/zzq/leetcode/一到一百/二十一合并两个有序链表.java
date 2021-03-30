package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 二十一合并两个有序链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode pre = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		while (l1 != null) {
			head.next = l1;
			l1 = l1.next;
			head = head.next;
		}
		while (l2 != null) {
			head.next = l2;
			l2 = l2.next;
			head = head.next;
		}
		return pre.next;
	}
}
