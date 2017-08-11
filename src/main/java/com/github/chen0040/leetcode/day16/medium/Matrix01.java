package com.github.chen0040.leetcode.day16.medium;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/01-matrix/description/
 */
public class Matrix01 {
   public class Solution {
      private boolean[] marked;
      private int rowCount;
      private int colCount;
      private int totalCount;
      private int[][] result;

      public int[][] updateMatrix(int[][] matrix) {
         rowCount = matrix.length;
         colCount = matrix[0].length;
         totalCount = rowCount * colCount;
         marked = new boolean[totalCount];
         result = new int[rowCount][];
         for(int i=0; i < rowCount; ++i) {
            result[i] = new int[colCount];
         }

         for(int v = 0; v < totalCount; ++v) {
            if(marked[v]) continue;
            int row = v / colCount;
            int col = v % colCount;
            if(matrix[row][col] == 0) continue;
            dfs(matrix, v, row, col);
         }

         return result;
      }

      private void dfs(int[][] matrix, int v, int row, int col) {
         marked[v] = true;

         int extent = Math.max(rowCount, colCount);
         boolean move_down = true, move_up = true, move_left = true, move_right = true;
         for(int k=1; k < extent; ++k) {
            move_down = move_down && row + k <= rowCount - 1;
            if(move_down && matrix[row+k][col] == 0) {
               result[row][col] = k;
               break;
            }
            move_up = move_up && row - k >= 0;
            if(move_up && matrix[row-k][col] == 0) {
               result[row][col] = k;
               break;
            }
            move_right = move_right && col + k <= colCount - 1;
            if(move_right && matrix[row][col+k] == 0) {
               result[row][col] = k;
               break;
            }
            move_left = move_left && col - k >= 0;
            if(move_left && matrix[row][col-k] == 0) {
               result[row][col] = k;
               break;
            }
            if(!move_down && !move_up && !move_left && !move_right) break;
         }


         for(int ii = -1; ii <= 1; ++ii) {
            if(ii == 0) continue;
            int row_i = row + ii;
            int index_i = row_i * colCount + col;
            if(row_i < rowCount && row_i >= 0 && matrix[row_i][col] == 1) {
               if(!marked[index_i]) {
                  dfs(matrix, index_i, row_i, col);
               }
               result[row][col] = Math.min(result[row][col], 1 + result[row_i][col]);
            }

            int col_i = col + ii;
            index_i = row * colCount + col_i;
            if(col_i < colCount && col_i >= 0 && matrix[row][col_i] == 1) {
               if(!marked[index_i]) {
                  dfs(matrix, index_i, row, col_i);
               }
               result[row][col] = Math.min(result[row][col], 1 + result[row][col_i]);
            }
         }
      }


   }
}
