package com.zzq.leetcode.一到一百;

import java.util.Stack;

public class 二十有效的括号 {
	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
				stack.push(chars[i]);
			} else {
				if (!stack.isEmpty()) {
					Character pop = stack.pop();
					if (chars[i] == ')' && pop == '(') {
						continue;
					}
					if (chars[i] == ']' && pop == '[') {
						continue;
					}
					if (chars[i] == '}' && pop == '{') {
						continue;
					}
					return false;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
