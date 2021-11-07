package com.zzq.leetcode.周赛;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {


	public static void main(String[] args) {
		countVowels("noosabasboosa");
	}

	public static long countVowels(String word) {
		long counter = 0;
		char[] chars = word.toCharArray();
		for (char c : chars) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				counter++;
			}
		}
		long n = chars.length * (chars.length + 1) / 2;
		return counter * n / 2;
	}


	public static int countVowelSubstrings(String word) {
		HashSet<Character> set = new HashSet<>();
		int res = 0;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				for (int k = i; k <= j; k++) {
					if (chars[k] == 'a' || chars[k] == 'e' || chars[k] == 'i' || chars[k] == 'o' || chars[k] == 'u') {
						set.add(chars[k]);
					} else {
						break;
					}
				}
				if (set.size() == 5) {
					res++;
				}
				set.clear();
			}
		}
		return res;
	}

	public static int maxTwoEvents(int[][] events) {
		Arrays.sort(events, (o1, o2) -> o2[2] - o1[2]);
		int res = 0;
		for (int i = 0; i < events.length; i++) {
			int cur = events[i][2];
			res = Math.max(cur, res);
			for (int j = i + 1; j < events.length; j++) {
				if (events[j][2] + cur <= res) {
					break;
				}
				if (events[i][0] > events[j][1] || events[j][0] > events[i][1]) {
					res = Math.max(cur + events[j][2], res);
					break;
				}
			}
		}
		return res;
	}

	public int minimumOperations(int[] nums, int start, int goal) {
		LinkedList<Integer> lists = new LinkedList<>();
		lists.add(start);
		int count = 0;
		int res = -1;
		HashSet<Integer> set = new HashSet<>();
		while (!lists.isEmpty()) {
			int size = lists.size();
			count++;
			for (int i = 0; i < size; i++) {
				Integer first = lists.pollFirst();
				if (set.contains(first)) {
					break;
				}
				set.add(first);
				for (int num : nums) {
					int cur = first + num;
					int cur1 = first - num;
					int cur2 = first ^ num;
					if (cur == goal) {
						return count;
					}
					if (cur1 == goal) {
						return count;
					}
					if (cur2 == goal) {
						return count;
					}
					if (cur <= 1000 && cur >= 0) {
						lists.add(cur);
					}
					if (cur1 <= 1000 && cur >= 0) {
						lists.add(cur1);
					}
					if (cur2 <= 1000 && cur >= 0) {
						lists.add(cur2);
					}
				}
			}
		}
		return res;
	}


}
