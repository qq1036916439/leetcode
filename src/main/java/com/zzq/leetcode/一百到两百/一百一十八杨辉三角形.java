package com.zzq.leetcode.一百到两百;

import java.util.ArrayList;
import java.util.List;

public class 一百一十八杨辉三角形 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(1);
					continue;
				}
				list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
			}
			res.add(list);
		}
		return res;
	}
}
