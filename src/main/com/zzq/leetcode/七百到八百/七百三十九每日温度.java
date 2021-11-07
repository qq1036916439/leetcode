package com.zzq.leetcode.七百到八百;

import java.util.Stack;

public class 七百三十九每日温度 {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				res[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}
		return res;
	}
}
