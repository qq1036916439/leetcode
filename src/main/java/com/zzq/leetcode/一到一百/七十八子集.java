package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-24 1:14 下午
 */
public class 七十八子集 {
  public List<List<Integer>> subsets(int[] nums) {
    ArrayList<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    back(path,nums,res,0,used);
    return res;
  }
  void back(LinkedList<Integer> path,int[] nums,List<List<Integer>> res,int index,boolean[] used){
    res.add(new ArrayList<>(path));
    for (int i = index; i < nums.length; i++) {
      if(!used[i]){
        used[i]=true;
        path.add(nums[i]);
        back(path,nums,res,i+1,used);
        path.removeLast();
        used[i]=false;
      }
    }
  }
}
