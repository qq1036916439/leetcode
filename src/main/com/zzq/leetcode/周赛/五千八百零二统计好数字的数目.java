package com.zzq.leetcode.周赛;

/**
 * 快速幂
 */
public class 五千八百零二统计好数字的数目 {
	public static int countGoodNumbers(long n) {
		long k = n / 2;
		long i = n % 2;
		long res = 1;
		res = quick(4, k) % 1000000007;
		res = res * quick(5, k + i);

		return (int) (res % 1000000007);
	}

	public static int quick(long x, long y) {
		long ret = 1;
		long mul = x;
		while (y > 0) {
			if (y % 2 == 1) {
				ret = (ret * mul) % 1000000007;
			}
			mul = (mul * mul) % 1000000007;
			y = y / 2;
		}
		return (int) (ret % 1000000007);
	}

}
