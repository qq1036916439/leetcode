package com.zzq.leetcode.四百到五百;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author zhangzhiqiang
 * @date 2021-07-21 2:13 下午
 */
public class 四百九十六下一个最大的元素 {

	/**
	 * 单调队列
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		LinkedList<Integer> stack = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
				map.put(stack.removeLast(), nums2[i]);
			}
			stack.addLast(nums2[i]);
		}
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.getOrDefault(nums1[i], -1);
		}
		return res;
	}
}
