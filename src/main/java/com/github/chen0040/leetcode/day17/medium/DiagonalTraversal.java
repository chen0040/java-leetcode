package com.github.chen0040.leetcode.day17.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 12/8/2017.
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 */
public class DiagonalTraversal {
   public class Solution {
      public int[] findDiagonalOrder(int[][] matrix) {
         int arrow = 1;
         int rowCount = matrix.length;
         if(rowCount == 0) return new int[0];
         int colCount = matrix[0].length;
         int limit = rowCount * colCount;
         int rowIndex = 0;
         int colIndex = 0;
         int row = 0;
         int col = 0;
         boolean move_up = true;
         int index = 0;
         int[] res = new int[limit];
         while(true) {


            int i = row;
            int j = col;
            List<Integer> buffer = new ArrayList<Integer>();
            buffer.add(matrix[i][j]);
            while((i + 1) < rowCount && (j-1) >= 0 ) {
               i++;
               j--;
               buffer.add(matrix[i][j]);
            }

            if(move_up) {
               for(int k = buffer.size() - 1; k >= 0; --k) {
                  res[index++] = buffer.get(k);
               }
               move_up = false;
            } else {
               for(int k=0; k < buffer.size(); ++k) {
                  res[index++] = buffer.get(k);
               }

               move_up = true;
            }

            if(col < colCount-1) col++;
            else if(row < rowCount-1) row++;
            else break;

         }

         return res;
      }
   }
}
