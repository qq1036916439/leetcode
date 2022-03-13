package com.zzq.leetcode.一到一百;

/**
 * @author zhangzhiqiang
 */
public class 七十爬楼梯 {
	/**
	 *  https://leetcode-cn.com/problems/climbing-stairs/submissions/
	 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 */
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int a = 1;
		int b = 2;
		int c = 0;
		for (int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}
