package com.zzq.leetcode.七百到八百;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2022-05-05
 */
public class 七百一十三乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int window = 1;
        int result = 0;
        while (right < nums.length) {
            window = window * nums[right];
            while (window >= k) {
                window = window / nums[left];
                left++;
            }
            result = result + right - left + 1;
            right++;
        }
        return result;
    }
}
