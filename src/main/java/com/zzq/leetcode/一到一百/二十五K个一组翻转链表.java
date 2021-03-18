package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

import static com.zzq.leetcode.base.ListNodeFunction.arrayToListNode;
import static com.zzq.leetcode.base.ListNodeFunction.printListNode;

public class 二十五K个一组翻转链表 {
	public static ListNode reverseKGroup(ListNode head, int k) {
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

	public static ListNode[] myReverse(ListNode head, ListNode tail) {
		ListNode prev = null;
		ListNode p = head;
		while (prev != tail) {
			ListNode next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		return new ListNode[]{tail, head};
	}

	public static void main(String[] args) {
		ListNode listNode = arrayToListNode(1, 2, 3, 4, 5);
		ListNode listNode1 = reverseKGroup(listNode, 1);
		printListNode(listNode1);
	}
}
