package com.zzq.leetcode.一到一百;

public class 七十二编辑距离 {
	/**
	 * 给你两个单词word1和word2， 请返回将word1转换成word2 所使用的最少操作数。
	 * 你可以对一个单词进行如下三种操作：
	 * 插入一个字符
	 * 删除一个字符
	 * 替换一个字符
	 * 链接：https://leetcode-cn.com/problems/edit-distance
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public int minDistance(String word1, String word2) {
		char[] char1 = word1.toCharArray();
		char[] char2 = word2.toCharArray();
		int[][] dp = new int[char1.length + 1][char2.length + 1];
		for (int i = 1; i <= char1.length; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= char2.length; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= char1.length; i++) {
			for (int j = 1; j <= char2.length; j++) {
				if (char1[i - 1] == char2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(
							//删除 s1
							dp[i - 1][j], Math.min(
									// 增加
									dp[i][j - 1],
									// 改
									dp[i - 1][j - 1])) + 1;
				}
			}
		}
		return dp[char1.length][char2.length];
	}
}
