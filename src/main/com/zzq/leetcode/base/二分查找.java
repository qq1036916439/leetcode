package com.zzq.leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 二分查找 {

	public int searchLeft(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				right = mid - 1;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		return left;
	}

	public int searchRight(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				left = mid + 1;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		return left;
	}



	static HashMap<String, ArrayList<String>> map = new HashMap<>();
	static boolean result = false;
	public static boolean hasCycle(String graph) {
		String[] split = graph.split(",");
		String start = null;
		HashMap<String,Integer> used =new HashMap();
		for (String s : split) {
			String[] split1 = s.split("->");
			ArrayList<String> list = map.getOrDefault(split1[0], new ArrayList<>());
			list.add(split1[1]);
			map.put(split1[0], list);
		}
		for(int i=1;i<100;i++){
			dfs(used,i+"");
		}
		return result;
	}

	public static void dfs(HashMap<String,Integer> used, String start) {
		used.put(start,1);
		for (String s : map.getOrDefault(start, new ArrayList<String>())) {
			if(used.getOrDefault(s,0)==0){
				dfs(used, s);
			}else{
				if(used.getOrDefault(s,0)==1){
					result=true;
					return;
				}
			}
		}
		used.put(start,0);
	}

	public static void main(String[] args) {
		hasCycle("1->4,2->5,3->6,3->7,4->8,5->8,5->9,6->9,6->11,7->11,8->12,9->12,9->13,10->6,10->13,10->14,11->10,11->14");
	}
}
