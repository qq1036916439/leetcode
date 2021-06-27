package com.zzq.leetcode.八百到九百;//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
//
//
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1
//-> ... 这样的车站路线行驶。
//
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
//
//
// 示例 2：
//
//
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= routes.length <= 500.
// 1 <= routes[i].length <= 105
// routes[i] 中的所有值 互不相同
// sum(routes[i].length) <= 105
// 0 <= routes[i][j] < 106
// 0 <= source, target < 106
//
// Related Topics 广度优先搜索 数组 哈希表
// 👍 138 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class 八百一十五公交线路NumBusesToDestination {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		if(source==target){
			return 0;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				ArrayList<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());
				list.add(i);
				map.put(routes[i][j], list);
			}
		}
		int count = 0;
		HashSet<Integer> used = new HashSet<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				Integer poll = queue.poll();
				ArrayList<Integer> list = map.get(poll);
				for (int i1 = 0; i1 < list.size(); i1++) {
					Integer l = list.get(i1);
					if (used.contains(l)) {
						continue;
					}else {
						used.add(l);
					}
					for (int j = 0; j < routes[l].length; j++) {
						if (routes[l][j] == target) {
							return count;
						}
						if(poll==routes[l][j]){
							continue;
						}
						if(!used.contains(routes[l][j])){
							queue.add(routes[l][j]);
						}
					}
				}
			}
		}
		return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
