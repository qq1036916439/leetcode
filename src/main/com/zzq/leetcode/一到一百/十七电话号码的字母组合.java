package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhiqiang
 * @date 2021-03-22 12:58 下午
 */
public class 十七电话号码的字母组合 {

	Map<Character, String> phoneMap = new HashMap<Character, String>() {{
		put('2', "abc");
		put('3', "def");
		put('4', "ghi");
		put('5', "jkl");
		put('6', "mno");
		put('7', "pqrs");
		put('8', "tuv");
		put('9', "wxyz");
	}};
	public List<String> res = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0 || digits == "") {
			return res;
		}
		StringBuffer path = new StringBuffer();
		back(path, digits, 0);
		return res;
	}

	void back(StringBuffer path, String digits, int index) {
		if (path.length() == digits.length()) {
			res.add(path.toString());
			return;
		}
		for (int i = index; i < digits.length(); i++) {
			String str = phoneMap.get(digits.charAt(i));
			for (int j = 0; j < str.length(); j++) {
				path.append(str.charAt(j));
				back(path, digits, i + 1);
				path.deleteCharAt(path.length() - 1);
			}
		}
	}
}
