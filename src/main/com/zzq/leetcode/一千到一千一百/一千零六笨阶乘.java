package com.zzq.leetcode.一千到一千一百;

import java.util.Stack;

/**
 * @author zhangzhiqiang
 * @date 2021-04-01 12:56 下午
 */
public class 一千零六笨阶乘 {

	public int clumsy(int N) {
		Stack<Integer> stack = new Stack<>();
		stack.push(N);
		N--;
		int index = 0;
		while (N > 0) {
			int num = index % 4;
			if (num == 0) {
				stack.push(stack.pop() * N);
			} else {
				if (num == 1) {
					stack.push(stack.pop() / N);
				} else {
					if (num == 2) {
						stack.push(N);
					} else {
						stack.push(-N);
					}
				}
			}
			N--;
			index++;
		}
		int res = 0;
		while (!stack.empty()) {
			res += stack.pop();
		}
		return res;
	}
}
