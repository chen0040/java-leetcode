package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class SearchA2DMatrix {
   public class Solution {
      public boolean searchMatrix(int[][] matrix, int target) {
         int rowCount = matrix.length;
         if(rowCount == 0) return false;
         int colCount = matrix[0].length;
         int len = rowCount * colCount;
         int lo = 0;
         int hi = len - 1;
         while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / colCount;
            int col = mid % colCount;
            int val = matrix[row][col];
            if(val == target) return true;
            else if(val < target) {
               lo = mid + 1;
            } else {
               hi = mid - 1;
            }
         }

         return false;

      }
   }
}
