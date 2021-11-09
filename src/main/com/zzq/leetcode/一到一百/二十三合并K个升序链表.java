package com.zzq.leetcode.一到一百;

import com.zzq.leetcode.base.ListNode;

import java.util.PriorityQueue;

public class 二十三合并K个升序链表 {
	public static class Status implements Comparable<Status> {
		int val;
		ListNode node;

		Status(int val, ListNode node) {
			this.val = val;
			this.node = node;
		}

		@Override
		public int compareTo(Status status2) {
			return this.val - status2.val;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Status> priorityQueue = new PriorityQueue<>();
		for (ListNode list : lists) {
			if (list != null) {
				priorityQueue.add(new Status(list.val, list));
			}
		}
		ListNode head = new ListNode();
		ListNode cur = head;
		while (!priorityQueue.isEmpty()) {
			Status poll = priorityQueue.poll();
			cur.next = poll.node;
			if (poll.node.next != null) {
				priorityQueue.add(new Status(poll.node.next.val, poll.node.next));
			}
			cur = cur.next;
		}
		return head.next;
	}

	/**
	 * 归并解法
	 */
	public static class 二十三合并K个升序链表2 {
		public ListNode mergeKLists(ListNode[] lists) {
			return merge(lists, 0, lists.length - 1);
		}

		public ListNode merge(ListNode[] node, int left, int right) {
			if (left == right) {
				return node[left];
			}
			if (left > right) {
				return null;
			}
			int mid = (left + right) / 2;
			return mergeTwo(merge(node, left, mid), merge(node, mid + 1, right));
		}

		public ListNode mergeTwo(ListNode l1, ListNode l2) {
			if (l1 == null || l2 == null) {
				return l1 == null ? l2 : l1;
			}
			ListNode head = new ListNode();
			ListNode cur = head;
			while (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					cur.next = l2;
					l2 = l2.next;
				} else {
					cur.next = l1;
					l1 = l1.next;
				}
				cur = cur.next;
			}
			while (l1 != null) {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
			}
			while (l2 != null) {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
			}
			return head.next;
		}
	}
}
