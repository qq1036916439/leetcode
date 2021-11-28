package com.zzq.leetcode.七百到八百;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-06-25 4:38 下午
 */
public class 七百五十二打开转盘锁 {


	public int openLock(String[] deadends, String target) {
		if ("0000".equals(target)) {
			return 0;
		}
		HashSet<String> used = new HashSet<>();
		LinkedList<String> queue = new LinkedList<>();
		for (String deadend : deadends) {
			used.add(deadend);
		}
		if (used.contains("0000")) {
			return -1;
		}
		int count = 0;
		queue.offer("0000");
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.pollFirst();
				List<String> strs = get(str);
				for (int j = 0; j < strs.size(); j++) {
					if (!used.contains(strs.get(j))) {
						if (target.equals(strs.get(j))) {
							return count;
						}
						used.add(strs.get(j));
						queue.offer(strs.get(j));
					}
				}
			}
		}
		return -1;
	}

	public char numPrev(char x) {
		return x == '0' ? '9' : (char) (x - 1);
	}

	public char numSucc(char x) {
		return x == '9' ? '0' : (char) (x + 1);
	}

	public List<String> get(String str) {
		char[] chars = str.toCharArray();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			char num = chars[i];

			chars[i] = numPrev(num);
			result.add(new String(chars));
			chars[i] = numSucc(num);
			result.add(new String(chars));

			chars[i] = num;
		}
		return result;
	}
}
