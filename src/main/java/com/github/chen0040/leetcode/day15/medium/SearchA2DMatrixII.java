package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class SearchA2DMatrixII {
   public class Solution {
      public boolean searchMatrix(int[][] matrix, int target) {
         int rowCount = matrix.length;
         if(rowCount == 0) return false;
         int colCount = matrix[0].length;
         if(rowCount < colCount){
            for(int i=0; i < rowCount; ++i) {

               int[] row = matrix[i];
               int lo2 = 0;
               int hi2 = colCount-1;
               while(lo2 <= hi2) {
                  int mid2 = lo2 + (hi2 - lo2) / 2;
                  if(row[mid2] == target) return true;
                  else if(row[mid2] < target) lo2 = mid2 + 1;
                  else hi2 = mid2 - 1;
               }

            }
         } else {
            for(int i=0; i < colCount; ++i) {

               int lo2 = 0;
               int hi2 = rowCount-1;
               while(lo2 <= hi2) {
                  int mid2 = lo2 + (hi2 - lo2) / 2;
                  if(matrix[mid2][i] == target) return true;
                  else if(matrix[mid2][i] < target) lo2 = mid2 + 1;
                  else hi2 = mid2 - 1;
               }

            }
         }

         return false;
      }
   }
}
