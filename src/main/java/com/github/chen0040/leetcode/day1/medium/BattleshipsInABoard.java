package com.github.chen0040.leetcode.day1.medium;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 *
 * link: https://leetcode.com/problems/battleships-in-a-board/tabs/description
 */
public class BattleshipsInABoard {
   public class Solution {
      private boolean[][] marked;
      private int rowCount;
      private int colCount;
      private int count = 0;


      public int countBattleships(char[][] board) {
         rowCount = board.length;
         colCount = board[0].length;
         count = 0;
         marked = new boolean[rowCount][];
         for (int i = 0; i < rowCount; ++i) {
            marked[i] = new boolean[colCount];
         }
         for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < colCount; ++j) {

               if (board[i][j] != 'X')
                  continue;
               if (!marked[i][j]) {
                  dfs(board, i, j);
                  count++;
               }
            }
         }
         return count;
      }


      private void dfs(char[][] board, int i, int j) {
         marked[i][j] = true;
         for (int ii = -1; ii <= 1; ++ii) {
            if (i + ii > rowCount - 1 || i + ii < 0)
               continue;
            if (board[i + ii][j] != 'X')
               continue;
            if (!marked[i + ii][j]) {
               dfs(board, i + ii, j);
            }
         }
         for (int jj = -1; jj <= 1; ++jj) {
            if (j + jj > colCount - 1 || j + jj < 0)
               continue;
            if (board[i][j + jj] != 'X')
               continue;
            if (!marked[i][j + jj]) {
               dfs(board, i, j + jj);
            }
         }
      }
   }
}
