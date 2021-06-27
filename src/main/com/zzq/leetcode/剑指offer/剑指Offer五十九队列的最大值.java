package com.zzq.leetcode.剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 剑指Offer五十九队列的最大值 {

	Queue<Integer> q = new LinkedList<>();
	LinkedList<Integer> dq = new LinkedList<>();
	Queue<Integer> queue;
	Deque<Integer> deque;

	public 剑指Offer五十九队列的最大值() {
		queue = new LinkedList<>();
		deque = new LinkedList<>();
	}

	public int max_value() {
		return deque.isEmpty() ? -1 : deque.peekFirst();
	}

	public void push_back(int value) {
		queue.offer(value);
		while (!deque.isEmpty() && deque.peekLast() < value) deque.pollLast();
		deque.offerLast(value);
	}

	public int pop_front() {
		if (queue.isEmpty()) return -1;
		if (queue.peek().equals(deque.peekFirst())) deque.pollFirst();
		return queue.poll();
	}
}
