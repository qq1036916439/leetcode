package com.zzq.leetcode.四百到五百;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-07-21 3:39 下午
 */
public class 四百三十八找到字符串中所有的字符异或词 {

  public List<Integer> findAnagrams(String s, String p) {
    int[] window = new int[128];
    int[] needs = new int[128];
    char[] pchars = p.toCharArray();
    int need = 0;
    for (int i = 0; i < pchars.length; i++) {
      if (needs[pchars[i]] == 0) {
        need++;
      }
      needs[pchars[i]]++;
    }
    char[] chars = s.toCharArray();
    int left = 0;
    int right = 0;
    List<Integer> res = new ArrayList<>();
    int nee = 0;
    while (right < chars.length) {
      char aChar = chars[right];
      right++;
      window[aChar]++;
      if (window[aChar] == needs[aChar]) {
        nee++;
      }
      while (right - left > pchars.length - 1) {
        char aaa = chars[left];
        if (nee == need) {
          res.add(left);
        }
        if (window[aaa] == needs[aaa]) {
          nee--;
        }
        left++;
        window[aaa]--;
      }
    }
    return res;
  }
}
