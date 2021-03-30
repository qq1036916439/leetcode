package com.zzq.leetcode.一百到两百;

public class 一百三十四加油站 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int index = 0;
		while (index < n) {
			int sumGas = 0;
			int sumCos = 0;
			int count = 0;
			while (count < n) {
				int j = (index + count) % n;
				sumGas += gas[j];
				sumCos += cost[j];
				if (sumCos > sumGas) {
					break;
				}
				count++;
			}
			if (count == n) {
				return index;
			} else {
				index = index + count + 1;
			}
		}
		return -1;
	}
}
