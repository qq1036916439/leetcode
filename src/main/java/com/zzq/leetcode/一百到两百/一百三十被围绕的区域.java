package com.zzq.leetcode.一百到两百;

public class 一百三十被围绕的区域 {
	public void solve(char[][] board) {
		int n = board.length;
		if (n == 0) {
			return;
		}
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			dfs(board, i, 0);
			dfs(board, i, m - 1);
		}
		for (int i = 1; i < m - 1; i++) {
			dfs(board, 0, i);
			dfs(board, n - 1, i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}

	}

	void dfs(char[][] board, int x, int y) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length||board[x][y]!='O'){
			return;
		}
		board[x][y]='A';
		dfs(board,x+1,y);
		dfs(board,x-1,y);
		dfs(board,x,y+1);
		dfs(board,x,y-1);
	}
}
