package com.zzq.leetcode.一百到两百;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-26 7:35 下午
 */
public class 一百三十一分割回文字符串 {

  public List<List<String>> partition(String s) {
    int n = s.length();
    List<List<String>> res = new ArrayList<>();
    boolean[][] f = new boolean[n][n];
    for (int i = 0; i < f.length; i++) {
      Arrays.fill(f[i], true);
    }
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
      }
    }
    LinkedList<String> path = new LinkedList<>();
    dfs(f, s, 0, res, path);
    return res;
  }

  void dfs(boolean[][] f, String s, int index, List<List<String>> res, LinkedList<String> path) {
    if (index == s.length()) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (f[index][i]) {
        path.add(s.substring(index, i + 1));
        dfs(f, s, i + 1, res, path);
        path.removeLast();
      }
    }
  }
}
