package com.zzq.leetcode.周赛;

import com.zzq.leetcode.base.ListNode;
import com.zzq.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {


	public static void main(String[] args) {
		System.out.println(longestPalindrome(new String[]{"cc","ll","xx"}));
		;
	}

	public static int longestPalindrome(String[] words) {
		HashMap<String, Integer> counter = new HashMap<>();
		int res = 0;
		HashSet<String> used = new HashSet<>();
		for (String word : words) {
			counter.put(word, counter.getOrDefault(word, 0) + 1);
		}
		Set<String> set = counter.keySet();
		boolean flag=false;
		for (String str : set) {
			if (used.contains(str)) {
				continue;
			}
			String rev = rev(str);
			if (str.charAt(0) != str.charAt(1)) {
				Integer num1 = counter.getOrDefault(str, 0);
				Integer num2 = counter.getOrDefault(rev, 0);
				res += Math.min(num1, num2) * 4;
			}else {
				Integer num1 = counter.getOrDefault(str, 0);
				if(num1==1){
					if(!flag){
						flag=true;
						res+=2;
					}
				}else {
					res=num1*4+res;
				}
			}
			used.add(rev);
			used.add(str);
		}
		return res;
	}

	private static String rev(String str) {
		String res = "";
		return str.charAt(1) + "" + str.charAt(0);
	}

	public int pairSum(ListNode head) {
		ArrayList<Integer> nodes = new ArrayList<>();
		while (head != null) {
			nodes.add(head.val);
			head = head.next;
		}
		int left = 0;
		int right = nodes.size() - 1;
		int res = 0;
		while (left < right) {
			res = Math.max(res, nodes.get(left) + nodes.get(right));
			left++;
			right--;
		}
		return res;
	}

	public String capitalizeTitle(String title) {
		String res = "";
		String[] s = title.split(" ");
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() <= 2) {
				s[i] = s[i].toLowerCase();
			} else {
				s[i] = s[i].substring(0, 1).toUpperCase() + s[i].substring(1).toLowerCase();
			}
		}
		return res;
	}


	public void dfs(int[][] fruits, int k, int index, int sum, HashSet<Integer> set) {
		if (k <= 0) {
			return;
		}

		int left = index;
		while (left > 0 && fruits[index][0] - fruits[left][0] > k && !set.contains(left)) {
			left--;
			if (!set.contains(left)) {
				sum = fruits[left][1];
				break;
			}
		}
		int right = index;
		while (left > 0 && fruits[index][0] - fruits[right][0] > k && set.contains(right)) {
			right++;
			if (!set.contains(right)) {
				sum = fruits[right][1];
				break;
			}
		}
	}


	public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
		int n = plants.length;
		int ans = 0;
		int restA = capacityA;
		int restB = capacityB;
		int right = plants.length - 1;
		for (int i = 0; i < n; i++) {
			if (i == right) {
				if (restA > restB) {
					if (restA >= plants[i]) {
						restA -= plants[i];
					} else {
						ans++;
						restA = capacityA - plants[i];
					}
					plants[i] = 0;

					if (restB >= plants[right]) {
						restB -= plants[right];
					} else {
						ans++;
						restB = capacityB - plants[right];
					}
					plants[right] = 0;
					right--;
				} else {
					if (restB >= plants[right]) {
						restB -= plants[right];
					} else {
						ans++;
						restB = capacityB - plants[right];
					}
					plants[right] = 0;
					right--;

					if (restA >= plants[i]) {
						restA -= plants[i];
					} else {
						ans++;
						restA = capacityA - plants[i];
					}
					plants[i] = 0;
				}
				if (right == i) {
					break;
				}
			} else {
				if (restA >= plants[i]) {
					restA -= plants[i];
				} else {
					ans++;
					restA = capacityA - plants[i];
				}
				plants[i] = 0;

				if (restB >= plants[right]) {
					restB -= plants[right];
				} else {
					ans++;
					restB = capacityB - plants[right];
				}
				plants[right] = 0;
				right--;

				if (right == i) {
					break;
				}
			}
		}
		return ans;
	}

	public long subArrayRanges(int[] nums) {
		long res = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int j = i; j < nums.length; j++) {
				max = Math.max(max, nums[j]);
				min = Math.min(min, nums[j]);
				res = res + (max - min);
			}
		}
		return res;
	}

	public static int countPoints(String rings) {
		HashMap<String, HashSet<Character>> map = new HashMap<>();
		char[] chars = rings.toCharArray();
		for (int i = 0; i < chars.length; i += 2) {
			HashSet<Character> set = map.getOrDefault(chars[i + 1] + "", new HashSet<>());
			set.add(chars[i]);
			map.put(chars[i + 1] + "", set);
		}
		Set<Map.Entry<String, HashSet<Character>>> entries = map.entrySet();
		int count = 0;
		for (Map.Entry<String, HashSet<Character>> entry : entries) {
			if (entry.getValue().size() >= 3) {
				count++;
			}
		}
		return count;
	}

	public static List<Integer> goodDaysToRobBank(int[] security, int time) {
		ArrayList<Integer> res = new ArrayList<>();
		if (time == 0) {
			for (int i = 0; i < security.length; i++) {
				res.add(i);
			}
			return res;
		}
		con:
		for (int i = time; i < security.length - time; i++) {
			for (int j = i - time + 1; j < i + 1; j++) {
				if (security[j - 1] < security[j]) {
					continue con;
				}
			}
			for (int j = i + 1; j < i + time + 1; j++) {
				if (security[j - 1] > security[j]) {
					continue con;
				}
			}
			res.add(i);
		}
		return res;
	}

	HashMap<Integer, TreeNode> parMap = new HashMap();
	TreeNode startNode = null;
	TreeNode desNode = null;
	int sta = 0;
	int end = 0;

	public String getDirections(TreeNode root, int startValue, int destValue) {
		this.sta = startValue;
		this.end = destValue;
		dfs(root);
		LinkedList<TreeNode> list = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		list.add(startNode);
		while (!list.isEmpty()) {
			int size = list.size();
			while (size > 0) {
				size--;
				TreeNode poll = list.poll();
				if (poll.val == destValue) {
					break;
				}
				if (poll.left != null) {

				}
				if (poll.right != null) {

				}
				if (parMap.get(poll.val) != null) {

				}
			}
		}
		return sb.toString();
	}

	public void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.val == sta) {
			startNode = node;
		}
		if (node.val == end) {
			desNode = node;
		}
		dfs(node.left);
		dfs(node.right);
		if (node.left != null) {
			parMap.put(node.left.val, node);
		}
		if (node.right != null) {
			parMap.put(node.right.val, node);
		}
	}

	public void back(int[] nums, LinkedList<Integer> path, int index, LinkedList<List<Integer>> res, boolean[] used) {
		if (path.size() == 3) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			path.add(nums[i]);
			back(nums, path, index + 1, res, used);
			path.removeLast();
			used[i] = false;
		}
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
