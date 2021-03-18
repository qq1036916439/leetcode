package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 二两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode();
		ListNode tail = head;
		while (l1 != null || l2 != null || carry != 0) {
			int num1 = l1 == null ? 0 : l1.val;
			int num2 = l2 == null ? 0 : l2.val;
			int sum = num1 + num2 + carry;
			carry = sum / 10;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return head.next;
	}
}
