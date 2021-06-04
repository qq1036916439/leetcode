package com.zzq.leetcode.二百到三百;

import com.zzq.leetcode.base.ListNode;

public class 二百零六反转链表 {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode cur = head;
			head = head.next;
			cur.next = pre;
			pre = cur;
		}
		return pre;
	}
}
