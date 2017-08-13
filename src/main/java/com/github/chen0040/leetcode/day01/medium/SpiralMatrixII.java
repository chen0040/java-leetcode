package com.github.chen0040.leetcode.day01.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * link: https://leetcode.com/problems/spiral-matrix-ii/description/
 */
public class SpiralMatrixII {
   public class Solution {
      int UP = 0;
      int DOWN = 1;
      int LEFT = 2;
      int RIGHT = 3;
      public int[][] generateMatrix(int n) {
         int[][] matrix =new int[n][];
         for(int i=0; i < n; ++i) {
            matrix[i] = new int[n];
         }

         int left = 0;
         int right = n-1;
         int top = 0;
         int bottom = n-1;
         int row = 0;
         int col = 0;

         int dir = RIGHT;
         for(int i=0; i < n * n; ++i) {

            matrix[row][col] = i+1;

            if(dir == RIGHT) {
               col++;
               if(col >= right) {
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

         return matrix;
      }
   }
}
