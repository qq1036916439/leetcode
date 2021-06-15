package com.zzq.leetcode.八百到九百;

public class 八百五十二山脉数组的封顶索引 {
	public int peakIndexInMountainArray(int[] arr) {
		int index = 0;
		if (arr.length < 3) {
			return -1;
		}
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}
}
