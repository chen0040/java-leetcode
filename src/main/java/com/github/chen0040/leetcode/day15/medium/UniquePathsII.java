package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathsII {
   public class Solution {
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int rowCount = obstacleGrid.length;
         int colCount = obstacleGrid[0].length;
         int[][] dp = new int[rowCount][];
         for(int i=0; i < rowCount; ++i) {
            dp[i] = new int[colCount];
         }
         dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
         for(int i = 0; i < rowCount; ++i){
            for(int j = 0; j < colCount; ++j) {
               if(obstacleGrid[i][j] != 1) {
                  if(i >= 1 && j >= 1) {
                     dp[i][j] = dp[i-1][j] + dp[i][j-1];
                  } else if(i >= 1) {
                     dp[i][j] = dp[i-1][j];
                  } else if(j >= 1) {
                     dp[i][j] = dp[i][j-1];
                  }
               }
            }
         }
         return dp[rowCount-1][colCount-1];
      }
   }
}
