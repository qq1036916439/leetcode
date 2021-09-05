package com.zzq.leetcode.三百到四百;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class 三百八十O一时间插入删除和获取随机元素 {
	ArrayList<Integer> list = new ArrayList<>();
	HashMap<Integer, Integer> map = new HashMap();
	Random random = new Random();

	/** Initialize your data structure here. */
	public 三百八十O一时间插入删除和获取随机元素() {

	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int last = list.get(list.size() - 1);
		int index = map.get(val);
		map.put(last, index);
		list.set(index, last);
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
}
