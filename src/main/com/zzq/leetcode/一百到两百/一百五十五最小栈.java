package com.zzq.leetcode.一百到两百;

import java.util.Stack;

public class 一百五十五最小栈 {
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public 一百五十五最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.pop();
    }
}
