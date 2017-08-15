package com.github.chen0040.leetcode.day20.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by xschen on 15/8/2017.
 *
 * link: https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class PacificAtlanticWaterFlow {
   public class Solution {





      public List<int[]> pacificAtlantic(int[][] matrix) {
         int rowCount =matrix.length;
         if(rowCount == 0) return new ArrayList<int[]>();
         int colCount = matrix[0].length;



         int totalCount = rowCount * colCount;
         int[] types = new int[totalCount];
         for(int i=0; i < rowCount; ++i) {
            types[i * colCount] = 1;
            types[i * colCount + colCount-1] = 2;
         }
         for(int i=0; i < colCount; ++i) {
            types[i] = 1;
            types[(rowCount-1) * colCount + i] = 2;
         }

         List<int[]> res = new ArrayList<int[]>();
         types[colCount - 1] = 3;
         types[(rowCount-1) * colCount] = 3;

         if(rowCount != 1 && colCount != 1) {
            res.add(new int[] { 0, colCount-1});
            res.add(new int[] { rowCount-1, 0});
         }
         else if(rowCount == 1) {
            for(int i=0; i < colCount; ++i) {
               res.add(new int[] { 0, i });
            }
            return res;
         } else if(colCount == 1) {
            for(int i=0; i < rowCount; ++i) {
               res.add(new int[] { i, 0});
            }
            return res;
         }


         boolean[] can_reach_pacific = new boolean[totalCount];
         boolean[] can_reach_atlantic = new boolean[totalCount];
         for(int i=0; i < totalCount; ++i) {
            if(types[i] == 3) continue;
            boolean[] marked = new boolean[totalCount];

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(i);
            boolean reach_pacific = false;
            boolean reach_atlantic = false;
            while(!queue.isEmpty()) {
               int v = queue.remove();
               marked[v] = true;
               int row = v / colCount;
               int col = v % colCount;
               if(can_reach_pacific[v]) reach_pacific = true;
               if(can_reach_atlantic[v]) reach_atlantic = true;
               if(!(reach_pacific && reach_atlantic) || row == 0 || col == 0 || row == rowCount-1 || col == colCount - 1) {
                  if(types[v] == 1) reach_pacific = true;
                  else if(types[v] == 2) reach_atlantic = true;
                  else if(types[v] == 3) {
                     reach_pacific = true;
                     reach_atlantic = true;
                  }
               }
               if(reach_pacific) can_reach_pacific[i] = true;
               if(reach_atlantic) can_reach_atlantic[i] = true;
               if(reach_pacific && reach_atlantic) {
                  types[i] = 3;
                  res.add(new int[] { i / colCount, i % colCount });
                  break;
               }
               for(int ii=-1; ii <= 1; ++ii){
                  if(ii == 0) continue;
                  int row_i = ii + row;
                  int col_i = ii + col;
                  if(row_i >= 0 && row_i < rowCount && matrix[row_i][col] <= matrix[row][col]) {
                     int w = row_i * colCount + col;
                     if(!marked[w]) {
                        queue.add(w);
                     }
                  }
                  if(col_i >= 0 && col_i < colCount && matrix[row][col_i] <= matrix[row][col]) {
                     int w = row * colCount + col_i;
                     if(!marked[w]) {
                        queue.add(w);
                     }
                  }
               }
            }
         }

         return res;



      }
   }
}
