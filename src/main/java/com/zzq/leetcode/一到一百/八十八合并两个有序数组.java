package com.zzq.leetcode.一到一百;

public class 八十八合并两个有序数组 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[index] = nums1[m];
				m--;
				index--;
			} else {
				nums1[index] = nums2[n];
				n--;
				index--;
			}
		}
		while (m >= 0) {
			nums1[index] = nums1[m];
			m--;
			index--;
		}
		while (n >= 0) {
			nums1[index] = nums2[n];
			n--;
			index--;
		}
	}
}
