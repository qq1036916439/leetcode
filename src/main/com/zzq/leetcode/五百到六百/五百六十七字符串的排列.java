package com.zzq.leetcode.五百到六百;

/**
 * @author zhangzhiqiang
 * @date 2021-07-16 5:57 下午
 */
public class 五百六十七字符串的排列 {

  public boolean checkInclusion(String s1, String s2) {
    int need = 0;
    int[] needs = new int[128];
    int[] window = new int[128];
    int valid = 0;
    char[] chars = s1.toCharArray();
    char[] chars1 = s2.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (needs[chars[i]] == 0) {
        need++;
      }
      needs[chars[i]]++;
    }
    int left = 0;
    int right = 0;
    while (right < chars1.length) {
      char c = chars1[right];
      right++;
      window[c]++;
      if (window[c] == needs[c]) {
        valid++;
      }
      while (right - left > s1.length()) {
        char c1 = chars1[left];
        if (window[c1] == needs[c1]) {
          valid--;
        }
        window[c1]--;
        left++;
      }
      if (need == valid) {
        return true;
      }
    }
    return false;
  }
}
