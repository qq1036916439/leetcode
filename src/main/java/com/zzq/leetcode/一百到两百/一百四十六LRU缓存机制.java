package com.zzq.leetcode.一百到两百;

import java.util.HashMap;

/**
 * @author zhangzhiqiang
 * @date 2021-03-29 1:29 下午
 */
public class 一百四十六LRU缓存机制 {

  public MyNode                   head;
  public MyNode                   tail;
  public int                      capacity;
  public int                      size  = 0;
  public HashMap<Integer, MyNode> cache = new HashMap();

  public 一百四十六LRU缓存机制(int capacity) {
    this.capacity = capacity;
    head = new MyNode(-1, -1);
    tail = new MyNode(-1, -1);
    tail.pre = head;
    head.next = tail;
  }

  public int get(int key) {
    MyNode node = cache.get(key);
    if (node == null) {
      return -1;
    }
    remove(node);
    addHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    MyNode node = cache.get(key);
    if (node == null) {
      MyNode myNode = new MyNode(key, value);
      cache.put(key, myNode);
      addHead(myNode);
      if (cache.size() > capacity) {
        cache.remove(tail.pre.key);
        remove(tail.pre);
      }
    } else {
      node.val = value;
      remove(node);
      addHead(node);
    }
  }

  /**
   * 删除当前节点
   */
  public void remove(MyNode node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  /**
   * 添加节点到头
   */
  public void addHead(MyNode node) {
    node.next = head.next;
    node.pre = head;
    head.next = node;
    node.next.pre = node;
  }

  public class MyNode {

    public int    key;
    public int    val;
    public MyNode pre;
    public MyNode next;

    public MyNode(int key, int value) {
      this.key = key;
      this.val = value;
    }
  }
}
