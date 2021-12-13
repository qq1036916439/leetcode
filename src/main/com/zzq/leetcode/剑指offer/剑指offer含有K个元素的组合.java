package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-12-13
 */
public class 剑指offer含有K个元素的组合 {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        back(new LinkedList<>(), 1, n, k);
        return res;
    }

    public void back(LinkedList<Integer> path, int index, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            back(path, i + 1, n, k);
            path.removeLast();
        }
    }
}
