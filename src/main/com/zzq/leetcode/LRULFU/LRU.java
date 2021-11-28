package com.zzq.leetcode.LRULFU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzhiqiang
 * @date 2021-03-22 1:18 下午
 */
public class LRU {

	DLinkedNode head;
	DLinkedNode tail;
	int capacity;
	Map<Integer, DLinkedNode> cache = new HashMap<>();

	class DLinkedNode {

		DLinkedNode next;
		DLinkedNode prev;
		int key;
		int value;

		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public DLinkedNode() {
		}
	}

	public LRU(int capacity) {
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
		this.capacity = capacity;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		removeNode(node);
		addToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			// 如果 key 不存在，创建一个新的节点
			DLinkedNode newNode = new DLinkedNode(key, value);
			// 添加进哈希表
			cache.put(key, newNode);
			// 添加至双向链表的头部
			addToHead(newNode);
			if (cache.size() > capacity) {
				//从链表和缓存中删最后一个节点
				DLinkedNode prev = tail.prev;
				removeNode(prev);
				cache.remove(prev.key);
			}
		} else {
			// 如果 key 存在，先通过哈希表定位，修改 value，并移到头部
			node.value = value;
			removeNode(node);
			addToHead(node);
		}
	}

	private void removeNode(DLinkedNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void addToHead(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}

	public static void main(String[] args) {
		LRU cache = new LRU(2 /* 缓存容量 */);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // 返回  1
		cache.put(3, 3);    // 该操作会使得关键字 2 作废
		System.out.println(cache.get(2));       // 返回 -1 (未找到)
		cache.put(4, 4);    // 该操作会使得关键字 1 作废
		System.out.println(cache.get(1));       // 返回 -1 (未找到)
		System.out.println(cache.get(3));       // 返回  3
		System.out.println(cache.get(4));       // 返回  4
	}
}
