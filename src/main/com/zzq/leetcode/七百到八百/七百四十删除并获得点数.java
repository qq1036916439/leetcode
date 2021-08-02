package com.zzq.leetcode.七百到八百;

public class 七百四十删除并获得点数 {
	public int deleteAndEarn(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		} else {
			if (nums.length == 1) {
				return nums[0];
			}
		}
		int len = nums.length;
		int max = nums[0];
		for (int i = 0; i < len; i++) {
			max = Math.max(nums[i], max);
		}
		int[] all = new int[max + 1];
		for (int num : nums) {
			all[num]++;
		}
		int[] dp = new int[max + 1];
		dp[1] = all[1];
		dp[2] = Math.max(dp[1], all[2] * 2);
		for (int i = 2; i < all.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
		}
		return dp[max];
	}

	public int deleteAndEarn1(int[] nums) {
		int max=0;
		for (int num : nums) {
			max=Math.max(max,num);
		}
		int[] s = new int[max+1];
		for (int num : nums) {
			s[num]+=num;
		}
		int first=s[0];
		int senc=Math.max(s[0],s[1]);
		for (int i = 2; i < s.length; i++) {
			int tem=senc;
			senc=Math.max(first+s[i],senc);
			first=tem;
		}
		return senc;
	}
}
