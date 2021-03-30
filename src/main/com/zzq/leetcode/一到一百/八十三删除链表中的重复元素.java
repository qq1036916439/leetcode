package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 八十三删除链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode pre = head;
		while (pre.next != null) {
			if (pre.val == pre.next.val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}
		return head;
	}
}
