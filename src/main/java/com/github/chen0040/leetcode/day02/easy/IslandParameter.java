package com.github.chen0040.leetcode.day02.easy;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * link: https://leetcode.com/problems/island-perimeter/tabs/description
 */
public class IslandParameter {
   public class Solution {
      private int width;
      private int height;
      private int count;
      private int connections;
      private boolean[][] marked;
      public int islandPerimeter(int[][] grid) {
         width = grid[0].length;
         height = grid.length;
         count = 0;
         connections = 0;
         marked = new boolean[height][];
         for(int i=0; i < height; ++i) {
            marked[i] = new boolean[width];
         }
         for(int i=0; i < height; ++i) {
            boolean found = false;
            for(int j=0; j < width; ++j) {
               if(grid[i][j] == 1) {
                  dfs(grid, i, j);
                  found = true;
                  break;
               }
            }
            if(found)  break;
         }

         return count * 4 - connections;
      }

      private void dfs(int[][] grid, int i, int j) {

         count++;
         marked[i][j] = true;

         for(int k=-1; k <= 1; ++k) {
            if(k==0) continue;
            int row = k + i;
            if(row > height-1 || row < 0) continue;
            if(grid[row][j] == 1) {
               connections++;
               if(!marked[row][j]){
                  dfs(grid, row, j);
               }

            }
         }

         for(int k=-1; k <= 1; ++k) {
            if(k==0) continue;
            int col = k + j;
            if(col > width-1 || col < 0) continue;
            if(grid[i][col] == 1) {
               connections++;
               if(!marked[i][col]) {
                  dfs(grid, i, col);
               }
            }
         }
      }
   }
}
