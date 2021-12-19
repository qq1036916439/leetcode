package com.zzq.leetcode.剑指offer;

public class 剑指offer狒狒吃香蕉 {

	public int minEatingSpeed(int[] piles, int h) {
		int l = 1;
		int r = 1000000000;
		while (l < r) {
			int mi = (l + r) / 2;
			if (!process(piles, h, mi)) {
				l = mi + 1;
			} else {
				r = mi;
			}
		}
		return l;
	}

	public boolean process(int[] piles, int h, int k) {
		int time = 0;
		for (int i = 0; i < piles.length; i++) {
			time += (piles[i] - 1) / k + 1;
		}
		return time <= h;
	}
}
