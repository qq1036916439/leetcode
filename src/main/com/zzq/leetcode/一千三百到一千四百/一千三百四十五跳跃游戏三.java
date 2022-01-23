package com.zzq.leetcode.一千三百到一千四百;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 一千三百四十五跳跃游戏三 {

	public static void main(String[] args) {
		minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
	}

	public static int minJumps(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
			list.add(i);
			map.put(arr[i], list);
		}
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Integer> q = new LinkedList<>();
		q.add(0);
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer index = q.poll();
				int val = arr[index];
				if (index == arr.length - 1) {
					return res;
				}
				if (map.containsKey(val)) {
					for (Integer integer : map.get(val)) {
						if (set.add(integer)) {
							q.offer(integer);
						}
					}
					map.remove(val);
				}
				if (index - 1 >= 0 && set.add(index - 1)) {
					q.offer(index - 1);
				}
				if (index + 1 < arr.length && set.add(index + 1)) {
					q.offer(index + 1);
				}
			}
			res++;
		}
		return -1;
	}
}
