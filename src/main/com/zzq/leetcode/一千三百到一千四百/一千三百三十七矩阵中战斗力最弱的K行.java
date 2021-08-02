package com.zzq.leetcode.一千三百到一千四百;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 一千三百三十七矩阵中战斗力最弱的K行 {
	public int[] kWeakestRows(int[][] mat, int k) {
		int[][] conter = new int[mat.length][2];
		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					count++;
				}
			}
			conter[i] = new int[]{i, count};
		}
		Arrays.sort(conter, (a, b) -> (a[1] - b[1]));
		List<Integer> resList = new ArrayList();
		for (int i = 0; i < k; i++) {
			resList.add(conter[i][0]);
		}
		int[] res = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}
		return res;
	}
}
