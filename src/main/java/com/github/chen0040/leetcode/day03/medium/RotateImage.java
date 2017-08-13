package com.github.chen0040.leetcode.day03.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * link: https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {
   public class Solution {
      public void rotate(int[][] matrix) {
         int n = matrix.length;
         int offset1 = 0;
         int offset2 = n-1;
         int mid = n / 2;
         for(int k=0; k < mid; ++k) {
            for(int l = offset1; l < offset2; ++l) {
               int top = matrix[offset1][l];
               int right = matrix[l][offset2];
               int bottom = matrix[offset2][offset2 - l + offset1];
               int left = matrix[offset2 - l + offset1][offset1];

               matrix[offset1][l] = left; // left -> top
               matrix[l][offset2] = top; // top -> right
               matrix[offset2][offset2 - l + offset1] = right; // right -> bottom
               matrix[offset2 - l + offset1][offset1] = bottom;// bottom -> left;
            }
            offset1++;
            offset2--;
         }
      }
   }
}
