package com.github.chen0040.leetcode.day06.medium;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * link: https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeroes {
   public class Solution {
      public void setZeroes(int[][] matrix) {
         Set<Integer> rows = new HashSet<Integer>();
         Set<Integer> cols = new HashSet<Integer>();



         int rowCount = matrix.length;
         if(rowCount == 0) return;

         int colCount = matrix[0].length;
         for(int i=0; i < rowCount; ++i) {
            for(int j =0; j < colCount; ++j) {
               if(matrix[i][j] == 0) {
                  rows.add(i);
                  cols.add(j);
               }
            }
         }

         for(Integer row : rows) {
            for(int i = 0; i < colCount; ++i) {
               matrix[row][i] = 0;
            }
         }
         for(Integer col: cols) {
            for(int i=0; i < rowCount; ++i) {
               matrix[i][col] = 0;
            }
         }
      }

   }
}
