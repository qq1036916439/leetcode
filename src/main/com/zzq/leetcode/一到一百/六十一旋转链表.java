package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 六十一旋转链表 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		int length = 1;
		while (cur.next != null) {
			length++;
			cur = cur.next;
		}
		k = length - k % length;
		ListNode tail = cur;
		cur.next = head;
		cur = head;
		for (int i = 0; i < k; i++) {
			cur = cur.next;
			tail = tail.next;
		}
		tail.next = null;
		return cur;
	}
}
