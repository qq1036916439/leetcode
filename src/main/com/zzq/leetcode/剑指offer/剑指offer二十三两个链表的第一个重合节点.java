package com.zzq.leetcode.剑指offer;

import com.zzq.leetcode.base.ListNode;

public class 剑指offer二十三两个链表的第一个重合节点 {
	public com.zzq.leetcode.base.ListNode getIntersectionNode(com.zzq.leetcode.base.ListNode headA, com.zzq.leetcode.base.ListNode headB) {
		ListNode a = headA;
		com.zzq.leetcode.base.ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
