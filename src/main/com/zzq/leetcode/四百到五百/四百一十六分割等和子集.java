package com.zzq.leetcode.四百到五百;

/**
 * @author zhangzhiqiang
 * @date 2021-07-22 12:59 下午
 */
public class 四百一十六分割等和子集 {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 1) {
			return false;
		}
		int target = sum / 2;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = target; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num];
			}
		}
		return dp[target];
	}
}
