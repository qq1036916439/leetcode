package com.zzq.leetcode.五百到六百;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 五百五十四砌砖 {
	public int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < wall.size(); i++) {
			int r = 0;
			for (int j = 0; j < wall.get(i).size() - 1; j++) {
				r = r + wall.get(i).get(j);
				map.put(r, map.getOrDefault(r, 0) + 1);
			}
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			max = Math.max(entry.getValue(), max);
		}
		return wall.size() - max;
	}
}
