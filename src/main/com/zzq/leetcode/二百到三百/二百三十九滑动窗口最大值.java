package com.zzq.leetcode.二百到三百;

import java.util.LinkedList;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2022-04-20
 */
public class 二百三十九滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        LinkedList<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            if (q.peek() <= i - k) {
                q.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[q.peek()];
            }
        }
        return result;
    }
}
