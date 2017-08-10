package com.github.chen0040.leetcode.day15.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinPathSum {
   public class Solution {
      int rowCount;
      int colCount;
      Map<Integer, Integer> saved;
      public int minPathSum(int[][] grid) {
         saved = new HashMap<Integer, Integer>();
         rowCount = grid.length;
         colCount = grid[0].length;
         return traverse(grid, 0, 0, grid[0][0]);
      }

      private int traverse(int[][] grid, int row, int col){
         int index = row * colCount + col;
         if(saved.containsKey(index)) {
            return saved.get(index);
         } else {
            int addedCost = traverse(grid, row, col, grid[row][col]);
            saved.put(index, addedCost);
            return addedCost;
         }
      }

      private int traverse(int[][] grid, int row, int col, int cost) {
         if(row == rowCount - 1 && col == colCount - 1) {
            return cost;
         }

         if(row == rowCount - 1) {
            return cost + traverse(grid, row, col+1);
         }
         if(col == colCount - 1) {
            return cost + traverse(grid, row+1, col);
         }
         int minCost = Integer.MAX_VALUE;

         minCost = Math.min(minCost, cost + traverse(grid, row, col+1));
         minCost = Math.min(minCost, cost + traverse(grid, row+1, col));

         return minCost;
      }
   }
}
