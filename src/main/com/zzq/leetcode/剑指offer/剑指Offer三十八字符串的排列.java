package com.zzq.leetcode.剑指offer;

import java.util.HashSet;

/**
 * @author zhangzhiqiang
 * @date 2021-06-22 1:06 下午
 */
public class 剑指Offer三十八字符串的排列 {

  public String[] permutation(String s) {
    HashSet<String> set = new HashSet<>();
    dfs(s.toCharArray(), new StringBuffer(), set, new boolean[s.length()]);
    String[] res = new String[set.size()];
    int i = 0;
    for (String s1 : set) {
      res[i] = s1;
      i++;
    }
    return res;
  }

  public void dfs(char[] chars, StringBuffer sb, HashSet<String> set, boolean[] used) {
    if (sb.length() == chars.length) {
      set.add(sb.toString());
      return;
    }
    for (int i = 0; i < chars.length; i++) {
      if (!used[i]) {
        used[i] = true;
        sb.append(chars[i]);
        dfs(chars, sb, set, used);
        sb.deleteCharAt(sb.length() - 1);
        used[i] = false;
      }
    }
  }
}
