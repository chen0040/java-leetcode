package com.github.chen0040.leetcode.day25.easy;


/**
 * Created by xschen on 20/8/2017.
 *
 * summary:
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 */
public class ImageSmoother {
   class Solution {
      public int[][] imageSmoother(int[][] M) {
         int rowCount = M.length;
         int colCount = M[0].length;
         int[][] M2 = new int[rowCount][];
         for(int i=0; i < rowCount; ++i) {
            M2[i] = new int[colCount];
         }
         for(int i=0; i < rowCount; ++i) {
            for(int j=0; j < colCount; ++j) {
               int sum = 0;
               int count = 0;
               for(int ii=-1; ii <=1; ++ii) {
                  int row = i + ii;
                  if(row < 0 || row >= rowCount) continue;
                  for(int jj=-1; jj <= 1; ++jj) {
                     int col = j + jj;
                     if(col < 0 || col >= colCount) continue;
                     sum += M[row][col];
                     count++;
                  }
               }
               int val = (int)(Math.floor((double)sum / count));
               M2[i][j] = val;
            }
         }
         return M2;
      }
   }
}
