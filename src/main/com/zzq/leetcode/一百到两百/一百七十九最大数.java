package com.zzq.leetcode.一百到两百;

import java.util.Arrays;

/**
 * @author zhangzhiqiang
 * @date 2021-03-19 7:15 下午
 */
public class 一百七十九最大数 {

  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));//lambda表达式
    StringBuilder res = new StringBuilder();
    for (String s : strs) {
      if (res.toString().equals("0")) {
        res.delete(0, 1);
      }
      res.append(s);
    }
    return res.toString();
  }
}
