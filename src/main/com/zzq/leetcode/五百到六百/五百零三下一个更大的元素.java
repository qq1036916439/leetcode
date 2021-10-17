package com.zzq.leetcode.五百到六百;

import java.util.Arrays;
import java.util.Stack;

public class 五百零三下一个更大的元素 {
	public int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack();
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		for (int i = nums.length * 2 - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
				stack.pop();
			}
			res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[i % nums.length]);
		}
		return res;
	}
}
