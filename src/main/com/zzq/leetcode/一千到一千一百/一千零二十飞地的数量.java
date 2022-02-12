package com.zzq.leetcode.一千到一千一百;

public class 一千零二十飞地的数量 {
	public int numEnclaves(int[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			dfs(grid, i, 0, 0);
			dfs(grid, i, grid[0].length - 1, 0);
		}
		for (int i = 0; i < grid[0].length; i++) {
			dfs(grid, 0, i, 0);
			dfs(grid, grid.length - 1, i, 0);
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					res++;
				}
			}
		}
		return res;
	}

	public int dfs(int[][] grid, int x, int y, int count) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
			return 0;
		}
		grid[x][y] = 0;
		int r1 = dfs(grid, x + 1, y, count);
		int r2 = dfs(grid, x - 1, y, count);
		int r3 = dfs(grid, x, y + 1, count);
		int r4 = dfs(grid, x, y - 1, count);
		return count + 1 + r1 + r2 + r3 + r4;
	}
}
