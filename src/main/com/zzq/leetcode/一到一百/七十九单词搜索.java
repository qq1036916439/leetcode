package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 * @date 2021-03-24 1:29 下午
 */
public class 七十九单词搜索 {

	public boolean exist(char[][] board, String word) {
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (back(board, i, j, word, 0, used)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean back(char[][] board, int x, int y, String word, int index, boolean[][] used) {
		if (word.length() == index) {
			return true;
		}
		if (x < 0 || y < 0 || board.length == x || board[0].length == y || board[x][y] != word.charAt(index) || used[x][y]) {
			return false;
		}
		used[x][y] = true;
		boolean res =
				back(board, x + 1, y, word, index + 1, used) || back(board, x - 1, y, word, index + 1, used) || back(board, x, y + 1, word, index + 1, used) ||
						back(board, x, y - 1, word, index + 1, used);
		used[x][y] = false;
		return res;

	}
}
