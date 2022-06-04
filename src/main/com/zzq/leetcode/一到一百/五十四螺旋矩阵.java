package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.List;

public class 五十四螺旋矩阵 {
	public List<Integer> spiralOrder(int[][] matrix) {
		int x = 0;
		int y = 0;
		int x1 = matrix.length - 1;
		int y1 = matrix[0].length - 1;
		List<Integer> ans = new ArrayList();
		while (x <= x1 && y <= y1) {
			function(matrix, x++, y++, x1--, y1--, ans);
		}
		return ans;
	}

	public void function(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> ans) {
		if (x1 == x2) {
			while (y1 <= y2) {
				ans.add(matrix[x1][y1++]);
			}
			return;
		}
		if (y1 == y2) {
			while (x1 <= x2) {
				ans.add(matrix[x1++][y1]);
			}
			return;
		}
		int a = x1;
		int b = y1;
		while (b != y2) {
			ans.add(matrix[a][b++]);
		}

		while (a != x2) {
			ans.add(matrix[a++][b]);
		}
		while (b != y1) {
			ans.add(matrix[a][b--]);
		}

		while (a != x1) {
			ans.add(matrix[a--][b]);
		}
	}
}
