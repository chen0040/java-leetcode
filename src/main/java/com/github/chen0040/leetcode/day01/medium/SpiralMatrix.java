package com.github.chen0040.leetcode.day01.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * link: https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {
   public class Solution {
      int UP = 0;
      int DOWN = 1;
      int LEFT = 2;
      int RIGHT = 3;
      public List<Integer> spiralOrder(int[][] matrix) {
         int m = matrix.length;
         if(m==0) return new ArrayList<Integer>();
         int n = matrix[0].length;

         int left = 0;
         int right = n-1;
         int top = 0;
         int bottom = m-1;
         int row = 0;
         int col = 0;

         int dir = RIGHT;
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < n * m; ++i) {

            result.add(matrix[row][col]);

            if(dir == RIGHT) {
               col++;
               if(col > right) {
                  col = right;
                  row++;
                  dir = DOWN;
               }
               else if(col == right) {
                  dir = DOWN;
               }
            } else if(dir == DOWN) {
               row++;
               if(row >= bottom) {
                  dir = LEFT;
               }
            } else if(dir == LEFT) {
               col--;
               if(col <= left) {
                  dir = UP;
               }
            } else if(dir == UP) {
               row--;
               if(row <= top) {
                  dir = RIGHT;
                  left += 1;
                  right -= 1;
                  top += 1;
                  bottom -= 1;

                  row = top;
                  col = left;
               }
            }
         }

         return result;
      }
   }
}
