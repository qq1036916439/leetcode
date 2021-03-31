package com.zzq.leetcode.二百到三百;

/**
 * @author zhangzhiqiang
 * @date 2021-03-31 7:02 下午
 */
public class 二百四十搜索二维矩阵 {

  public boolean searchMatrix1(int[][] matrix, int target) {
    int row = matrix.length - 1;
    int col = 0;
    while (row >= 0 && col < matrix[0].length) {
      if (matrix[row][col] == target) {
        return true;
      }
      if (matrix[row][col] > target) {
        row--;
      } else {
        col++;
      }
    }
    return false;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
      if (searchMatrix(matrix[i], target)) {
        return true;
      }
    }
    return false;
  }

  public boolean searchMatrix(int[] matrix, int target) {
    int left = 0;
    int right = matrix.length-1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (matrix[mid] == target) {
        return true;
      }
      if (matrix[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }

}
