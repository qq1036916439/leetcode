package com.zzq.leetcode.周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 板子 {
	public static class UnionFindSet {
		public HashMap<Integer, Integer> fatherMap;
		public HashMap<Integer, Integer> sizeMap;

		public UnionFindSet() {
			fatherMap = new HashMap<Integer, Integer>();
			sizeMap = new HashMap<Integer, Integer>();
		}

		public void makeSets(List<Integer> nodes) {
			for (Integer node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		private Integer findHead(Integer node) {
			Integer father = fatherMap.get(node);
			if (!father.equals(node)) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		public boolean isSameSet(Integer a, Integer b) {
			Integer head = findHead(a);
			Integer head1 = findHead(b);
			return findHead(a).equals(findHead(b));
		}

		public void union(Integer a, Integer b) {
			Integer aHead = findHead(a);
			Integer bHead = findHead(b);
			if (!aHead.equals(bHead)) {
				Integer aSetSize = sizeMap.get(aHead);
				Integer bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static long countPairs(int n, int[][] edges) {
		long res = 0;
		if (edges.length == 0) {
			return (long) n * ((long) n - 1) / 2;
		}
		UnionFindSet unionFindSet = new UnionFindSet();
		ArrayList<Integer> ss = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ss.add(i);
		}
		unionFindSet.makeSets(ss);
		for (int i = 0; i < edges.length; i++) {
			unionFindSet.union(edges[i][0], edges[i][1]);
		}
		long size=0;
		for (int i = 0; i < edges.length; i++) {
			size+= unionFindSet.sizeMap.get(edges[i][0]);
		}
		return (long) n * ((long) n - 1) / 2 - size/2;
	}

	public static void main(String[] args) {
		countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}});
	}


}
