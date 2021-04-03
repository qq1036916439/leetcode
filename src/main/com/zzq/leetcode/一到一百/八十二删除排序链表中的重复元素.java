package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

public class 八十二删除排序链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode empty = new ListNode();
		empty.next = head;
		ListNode cur = empty;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;
				while (cur.next != null && cur.next.val == x) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return empty.next;
	}
}
