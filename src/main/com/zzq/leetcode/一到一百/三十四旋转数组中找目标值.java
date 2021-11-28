package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-03-23 1:38 下午
 */
public class 三十四旋转数组中找目标值 {

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				break;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (nums[mid] != target) {
			return new int[]{-1, -1};
		}
		int resLeft = mid;
		int resRight = mid;
		while (resLeft > 0 && nums[resLeft - 1] == target) {
			resLeft--;
		}
		while (resRight < nums.length - 1 && nums[resRight + 1] == target) {
			resRight++;
		}
		return new int[]{resLeft, resRight};
	}

	public static void main(String[] args) {
		System.out.println(searchRange(new int[]{1}, 1)[0] + "+" + searchRange(new int[]{1}, 1)[1]);
	}
}
