package com.zzq.leetcode.一到一百;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhiqiang
 * @date 2021-03-22 7:07 下午
 */
public class 二十二括号生成 {

	public List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		StringBuffer path = new StringBuffer();
		back(path, 0, 0, n);
		return res;
	}

	public void back(StringBuffer sb, int left, int right, int n) {
		if (sb.length() == n * 2) {
			res.add(sb.toString());
		}
		if (left < n) {
			sb.append("(");
			back(sb, left + 1, right, n);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			back(sb, left, right + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
