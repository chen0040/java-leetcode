package com.github.chen0040.leetcode.day04.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * link: https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {
   public class Solution {
      private boolean[][] marked;
      private int rowCount;
      private int colCount;
      private int count;
      public int numIslands(char[][] grid) {
         rowCount = grid.length;
         if(rowCount == 0) return 0;

         colCount = grid[0].length;
         marked = new boolean[rowCount][];
         count = 0;
         for(int rowIndex = 0; rowIndex < rowCount; ++rowIndex) {
            marked[rowIndex] = new boolean[colCount];
         }
         for(int rowIndex = 0; rowIndex < rowCount; ++rowIndex) {
            for(int colIndex = 0; colIndex < colCount; ++colIndex) {
               if(!marked[rowIndex][colIndex] && grid[rowIndex][colIndex] == '1') {
                  dfs(grid, rowIndex, colIndex);
                  count++;
               }
            }
         }
         return count;
      }

      private void dfs(char[][] grid, int i, int j) {
         marked[i][j] = true;
         for(int ii=-1; ii<=1; ++ii){
            int rowIndex = i + ii;
            if(rowIndex < 0 || rowIndex >= rowCount) continue;
            int colIndex = j;

            if(!marked[rowIndex][colIndex] && grid[rowIndex][colIndex]=='1') {
               dfs(grid, rowIndex, colIndex);
            }
         }

         for(int jj=-1; jj <= 1; ++jj) {

            int rowIndex = i;
            int colIndex = j + jj;
            if(colIndex < 0 || colIndex >= colCount) continue;

            if(!marked[rowIndex][colIndex] && grid[rowIndex][colIndex]=='1') {
               dfs(grid, rowIndex, colIndex);
            }
         }
      }
   }
}
