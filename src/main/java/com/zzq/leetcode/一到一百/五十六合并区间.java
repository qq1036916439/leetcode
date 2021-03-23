package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.Arrays;

public class 五十六合并区间 {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		ArrayList<int[]> objects = new ArrayList<>();
		for (int i = 0; i < intervals.length-1; i++) {
			if (intervals[i][1] >= intervals[i+1][0]) {
				intervals[i+1][0] = intervals[i ][0];
				intervals[i+1][1] = Math.max(intervals[i+1][1], intervals[i][1]);
			} else {
				objects.add(intervals[i]);
			}
		}
		objects.add(intervals[intervals.length - 1]);
		int[][] res = new int[objects.size()][2];
		for (int i = 0; i < objects.size(); i++) {
			res[i][0]=objects.get(i)[0];
			res[i][1]=objects.get(i)[1];
		}
		return res;
	}
}
