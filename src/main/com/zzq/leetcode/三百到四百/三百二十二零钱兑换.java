package com.zzq.leetcode.三百到四百;

import java.util.Arrays;

/**
 * @author zhangzhiqiang
 * @date 2021-03-31 5:50 下午
 */
public class 三百二十二零钱兑换 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
