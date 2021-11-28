package com.zzq.leetcode.五百到六百;

/**
 * @author zhangzhiqiang
 * @date 2021-04-20 2:01 下午
 */
public class 五百五十七翻转字符串中的单词二 {

	public String reverseWords(String s) {
		String[] s1 = s.split(" ");
		String res = "";
		for (int i = 0; i < s1.length; i++) {
			res += new StringBuffer(s1[i]).reverse().toString();
			if (i != s1.length - 1) {
				res += " ";
			}
		}

		return res;
	}
}
