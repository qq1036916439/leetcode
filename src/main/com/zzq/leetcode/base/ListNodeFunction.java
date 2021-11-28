package com.zzq.leetcode.base;

/**
 * @author zhangzhiqiang
 */
public class ListNodeFunction {

	public static ListNode arrayToListNode(int... val) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i : val) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		return head.next;
	}

	/**
	 * 按照顺序输出链表
	 * @param node
	 * @return
	 */
	public static void printListNode(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode curr = head;
		ListNode pre = new ListNode();
		ListNode next = null;
		for (int i = 1; i < m; i++) {
			pre = curr;
			curr = curr.next;
		}
		ListNode preNode = pre;
		for (int j = 1; j < n - m; j++) {
			next = curr.next;
			curr.next = preNode;
			preNode = curr;
			curr = next;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode listNode = arrayToListNode(1, 2, 3, 4, 5);
		reverseBetween(listNode, 2, 4);
	}


}
