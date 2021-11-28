package com.zzq.leetcode.七百到八百;

import java.util.HashMap;

public class 七百八十一森林中的兔子 {
	public int numRabbits(int[] answers) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < answers.length; i++) {
			if (!map.containsKey(answers[i]) || map.get(answers[i]) == 0) {
				map.put(answers[i], answers[i] + 1);//第一次预计一种颜色，备入到map
				sum += map.get(answers[i]);//直接加入最大值
			}
			map.put(answers[i], map.get(answers[i]) - 1);
			//后面每次遇见，直接减1，到0说明进入下一种颜色
		}
		return sum;

	}
}
