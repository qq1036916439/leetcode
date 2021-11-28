package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.ListNode;

public class 二百零六翻转链表 {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
