package com.github.chen0040.leetcode.day1.easy;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * link: https://leetcode.com/problems/reshape-the-matrix/tabs/description
 */
public class ReshapeTheMatrix {
   public class Solution {
      public int[][] matrixReshape(int[][] nums, int r, int c) {
         if (nums.length * nums[0].length != r * c)
            return nums;

         int[][] reshaped = new int[r][];
         for (int i = 0; i < r; ++i) {
            reshaped[i] = new int[c];
            for (int j = 0; j < c; ++j) {
               int index = i * c + j;
               int i1 = index / nums[0].length;
               int j1 = index % nums[0].length;
               reshaped[i][j] = nums[i1][j1];
            }
         }
         return reshaped;
      }
   }
}
