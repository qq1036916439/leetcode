package com.zzq.leetcode.一百到两百;

import java.util.HashSet;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-29 12:48 下午
 */
public class 一百三十九单词拆分 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < wordDict.size(); i++) {
      set.add(wordDict.get(i));
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[dp.length - 1];
  }
}
