package com.zzq.leetcode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangzhiqiang <zhangzhiqiang05@kuaishou.com>
 * Created on 2021-11-16
 */
public class 剑指offer八十七复原IP {

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        dfs(res, new LinkedList(), s, 0);
        return res;
    }

    public void dfs(List<String> res, LinkedList<String> path, String s, int begin) {
        if (begin == s.length()) {
            if (path.size() == 4) {
                String jo = path.stream().collect(Collectors.joining("."));
                res.add(jo);
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (begin + i >= s.length()) {
                break;
            }
            int i1 = judgeIfIpSegment(s, begin, begin + i);
            if (i1 != -1) {
                path.add(i1 + "");
                dfs(res, path, s, begin + i + 1);
                path.removeLast();
            }
        }
    }

    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }
        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255) {
            return -1;
        }
        return res;
    }
}
