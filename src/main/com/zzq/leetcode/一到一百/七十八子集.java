package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-24 1:14 下午
 */
public class 七十八子集 {
    /**
	 * https://leetcode.cn/problems/subsets/description/
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        dfs(nums, 0, new LinkedList(), result);
        return result;
    }

    public void dfs(int[] nums, int start, LinkedList<Integer> path, List<List<Integer>> result) {
        if (start > nums.length) {
            return;
        }
        result.add(new ArrayList(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.pollLast();
        }
    }
}
