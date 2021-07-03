package com.zzq.leetcode.base;

public class 二分查找 {

	public int searchLeft(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;
		while (left<=right){
			int mid=left+(right-left)/2;
			if(nums[mid]==target){
				right=mid-1;
			}
			if(nums[mid]<target){
				left=mid+1;
			}
			if(nums[mid]>target){
				right=mid-1;
			}
		}
		return left;
	}

	public int searchRight(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;
		while (left<=right){
			int mid=left+(right-left)/2;
			if(nums[mid]==target){
				left=mid+1;
			}
			if(nums[mid]<target){
				left=mid+1;
			}
			if(nums[mid]>target){
				right=mid-1;
			}
		}
		return left;
	}
}
