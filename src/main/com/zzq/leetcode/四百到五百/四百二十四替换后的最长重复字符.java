package com.zzq.leetcode.四百到五百;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-11-05
 */
public class 四百二十四替换后的最长重复字符 {
	public int characterReplacement(String s, int k) {
		char[] chars = s.toCharArray();
		int left = 0, right = 0, max = 0;
		int[] counter = new int[26];
		while (right < chars.length) {
			counter[chars[right] - 'A']++;
			max = Math.max(max, counter[chars[right] - 'A']);
			if (right - left + 1 - max > k) {
				counter[chars[left] - 'A']--;
				left++;
			}
			right++;
		}
		return right - left;
	}
}
