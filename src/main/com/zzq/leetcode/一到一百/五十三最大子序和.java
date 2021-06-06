package com.zzq.leetcode.一到一百;

public class 五十三最大子序和 {
	public int maxSubArray(int[] nums) {
		int cursum=nums[0];
		int reslut=nums[0];
		cursum=nums[0];
		for (int i = 1; i < nums.length; i++) {
			cursum=cursum+nums[i];
			cursum=Math.max(cursum,nums[i]);
			reslut=Math.max(reslut,cursum);
		}
		return reslut;
	}
}
