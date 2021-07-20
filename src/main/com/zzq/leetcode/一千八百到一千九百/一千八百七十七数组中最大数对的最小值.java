package com.zzq.leetcode.一千八百到一千九百;

import java.util.Arrays;

/**
 * @author zhangzhiqiang
 * @date 2021-07-20 11:50 上午
 */
public class 一千八百七十七数组中最大数对的最小值 {

  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;
    int res = 0;
    while (left < right) {
      res = Math.max(res, nums[left++] + nums[right--]);
    }
    return res;
  }
}
