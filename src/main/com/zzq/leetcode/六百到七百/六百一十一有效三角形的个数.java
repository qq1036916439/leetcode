package com.zzq.leetcode.六百到七百;

import java.util.Arrays;

public class 六百一十一有效三角形的个数 {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int count=0;
		for (int i = 0; i < nums.length-2; i++) {
			int k=i;
			for (int j = i+1; j < nums.length; j++) {
				for (int l = j+1; l < nums.length; l++) {
					if(nums[i]+nums[j]>nums[l]){
						count++;
					}else {
						break;
					}
				}
			}
		}
		return count;
	}
}
