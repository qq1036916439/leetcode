package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 二十五K个一组翻转链表 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode hari = new ListNode(0);
		hari.next = head;
		ListNode pre = hari;
		while (head != null) {
			ListNode tail = pre;
			for (int i = 0; i < k; i++) {
				tail = tail.next;
				if (tail == null) {
					return hari.next;
				}
			}
			ListNode nex = tail.next;
			ListNode[] reverse = myReverse(head, tail);
			head = reverse[0];
			tail = reverse[1];
			pre.next = head;
			tail.next = nex;
			pre = tail;
			head = tail.next;

		}
		return hari.next;
	}

	public ListNode[] myReverse(ListNode head, ListNode tail) {
		ListNode prev = tail.next;
		ListNode p = head;
		while (prev != tail) {
			ListNode next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		return new ListNode[]{tail, head};
	}
}
