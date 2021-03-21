package com.zzq.leetcode.一到一百;

public class 十一盛水最多的容器 {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		while (left < right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}
}
