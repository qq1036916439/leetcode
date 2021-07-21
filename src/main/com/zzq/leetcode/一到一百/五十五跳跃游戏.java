package com.zzq.leetcode.一到一百;

public class 五十五跳跃游戏 {
	public boolean canJump(int[] nums) {
		int n = nums.length;
		//跳跃最远距离
		int rightmost = 0;
		for (int i = 0; i < n; i++) {
			//如果当前坐标 小于去更新下 跳跃最远距离
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				//如果跳跃的距离 大于长度的话，直接return true。
				if (rightmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}
}
