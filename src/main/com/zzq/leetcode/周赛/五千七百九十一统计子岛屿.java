package com.zzq.leetcode.周赛;

public class 五千七百九十一统计子岛屿 {

	boolean flag = false;

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int res = 0;
		for (int i = 0; i < grid1.length; i++) {
			for (int j = 0; j < grid2[0].length; j++) {
				if (grid2[i][j] == 1) {
					flag = true;
					dfs(grid1, grid2, i, j);
					if (flag) {
						res++;
					}
				}
			}
		}
		return res;
	}

	public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
		if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0) return;
		grid2[i][j] = 0;
		if (grid1[i][j] == 0) {
			flag = false;
		}
		dfs(grid1, grid2, i - 1, j);
		dfs(grid1, grid2, i + 1, j);
		dfs(grid1, grid2, i, j - 1);
		dfs(grid1, grid2, i, j + 1);

	}
}
