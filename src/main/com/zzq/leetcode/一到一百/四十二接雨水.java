package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-04-02 1:19 下午
 */
public class 四十二接雨水 {

  public int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int[] leftMax = new int[height.length];
    leftMax[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    int[] right = new int[height.length];
    right[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], height[i]);
    }
    int res = 0;
    for (int i = 0; i < height.length; i++) {
      res += Math.min(leftMax[i], right[i]) - height[i];
    }
    return res;
  }
  public int trap1(int[] height) {
    int leftMax = 0;
    int rightMax = 0;
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int res = 0;
    while (leftIndex < rightIndex) {
      leftMax = Math.max(leftMax, height[leftIndex]);
      rightMax = Math.max(rightMax, height[rightIndex]);
      if (height[leftIndex] < height[rightIndex]) {
        res += (leftMax - height[leftIndex]);
        leftIndex++;
      } else {
        res += (rightMax - height[rightIndex]);
        rightIndex--;
      }
    } return res;
  }
}
