package com.zzq.leetcode.一到一百;

public class 四十八旋转图像 {

	public void rotate(int[][] matrix) {
		int a = 0;
		int b = matrix.length - 1;
		while (a < b) {
			rotate(matrix, a++, b--);
		}
	}

	public void rotate(int[][] matrix, int a, int b) {
		for (int i = 0; i < b - a; i++) {
			int tem = matrix[b - i][a];
			matrix[b - i][a] = matrix[b][b - i];
			matrix[b][b - i] = matrix[a + i][b];
			matrix[a + i][b] = matrix[a][a + i];
			matrix[a][a + i] = tem;
		}
	}
}
