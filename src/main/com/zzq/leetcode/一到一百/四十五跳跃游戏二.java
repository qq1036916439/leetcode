package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-07-21 2:50 下午
 */
public class 四十五跳跃游戏二 {
	public int jump(int[] nums) {
		int res = 0;
		int maxPos = 0;
		int end = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxPos = Math.max(maxPos, i + nums[i]);
			if (end == i) {
				res++;
				end = maxPos;
			}
		}
		return res;
	}
}
