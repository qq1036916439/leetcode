package main.com.zzq.leetcode.一千八百到一千九百;

import java.util.Arrays;

/**
 * @author zhangzhiqiang
 * @date 2021-07-02 1:58 下午
 */
public class 一千八百三十三雪糕的最大数量 {

	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int count = 0;
		for (int i = 0; i < costs.length; i++) {
			if (costs[i] <= coins) {
				count++;
				coins -= costs[i];
			} else {
				return count;
			}
		}
		return count;
	}
}
