package com.github.chen0040.leetcode.day15.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/minesweeper/description/
 */
public class Minesweeper {
   public class Solution {
      int rowCount;
      int colCount;
      boolean[] marked;
      public char[][] updateBoard(char[][] board, int[] click) {
         rowCount = board.length;
         colCount = board[0].length;

         int i = click[0];
         int j = click[1];
         int v = i * colCount + j;
         marked = new boolean[rowCount * colCount];
         dfs(board, v);

         return board;
      }

      private void dfs(char[][] board, int v) {
         marked[v] = true;
         int row = v / colCount;
         int col = v % colCount;

         if(board[row][col] == 'E') {
            List<Integer> mines = new ArrayList<Integer>();
            List<Integer> adj_v = new ArrayList<Integer>();
            for(int ii=-1; ii <= 1; ++ii) {
               int i = row + ii;
               if(i < 0 || i >= rowCount) continue;
               for(int jj = -1; jj <= 1; ++jj) {
                  int j = col + jj;
                  if(j < 0 || j >= colCount) continue;
                  if(ii == 0 && jj == 0) continue;
                  int w = i * colCount + j;
                  if(board[i][j] == 'M') {
                     mines.add(w);
                  }
                  adj_v.add(w);
               }
            }

            if(!mines.isEmpty()) {
               board[row][col] = (char)(mines.size() + (int)'0');
            } else {
               board[row][col] = 'B';
               for(Integer w : adj_v) {
                  if(!marked[w]) {
                     dfs(board, w);
                  }
               }
            }
         } else if(board[row][col] == 'M') {
            board[row][col] = 'X';
         }
      }
   }
}
