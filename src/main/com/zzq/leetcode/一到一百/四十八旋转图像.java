package com.zzq.leetcode.一到一百;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

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

	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		Arrays.sort(potions);
		TreeMap<Long, Integer> map = new TreeMap<>();
		for (int i = potions.length - 1; i >= 0; i--) {
			map.put((long) potions[i], i);
		}
		for (int i = 0; i < spells.length; i++) {
			spells[i] = potions.length - map.ceilingEntry((success + spells[i] - 1) / spells[i]).getValue();
		}
		return spells;
	}

}
