package com.zzq.leetcode.二百到三百;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2022-05-16
 */
public class 二百一十课程表二 {
    Boolean valid = true;
    int index = 0;
    HashMap<Integer, List<Integer>> map = new HashMap();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] used = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = map.getOrDefault(prerequisites[i][1], new ArrayList());
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], list);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (used[i] == 0) {
                dfs(i, result, used);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return result;
    }

    public void dfs(int u, int[] result, int[] used) {
        used[u] = 1;
        for (Integer num : map.getOrDefault(u, new ArrayList<>())) {
            if (used[num] == 0) {
                dfs(num, result, used);
                if (!valid) {
                    return;
                }
            } else {
                if (used[num] == 1) {
                    valid = false;
                    return;
                }
            }
        }
        used[u] = 2;
        result[index--] = u;
    }

}
