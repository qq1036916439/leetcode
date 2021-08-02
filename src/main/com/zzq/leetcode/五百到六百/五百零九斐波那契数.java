package com.zzq.leetcode.五百到六百;

/**
 * @author zhangzhiqiang
 * @date 2021-07-14 8:34 下午
 */
public class 五百零九斐波那契数 {

  public int fib(int n) {
    if (n < 2) {
      return n;
    }
    int first = 0;
    int second = 1;
    for (int i = 2; i <= n; i++) {
      int tem = second;
      second = first + second;
      first = tem;
    }
    return second;
  }
}
