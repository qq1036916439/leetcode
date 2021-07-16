package com.zzq.leetcode.剑指offer;

/**
 * @author zhangzhiqiang
 * @date 2021-07-16 11:03 上午
 */
public class 剑指Offer五十三在排序数组中查找数字 {

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int count = 0;
    while (left < nums.length && nums[left] == target) {
      count++;
      left++;
    }
    return count;
  }
}
