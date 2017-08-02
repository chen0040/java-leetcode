package com.github.chen0040.leetcode.day7.medium;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 2/8/2017.
 * summary:
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * link: https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {
   public class Solution {
      private boolean found;
      private int rowCount;
      private int colCount;
      public boolean exist(char[][] board, String word) {
         found = false;
         rowCount = board.length;
         if(word.length() == 0) return true;
         if(rowCount == 0) return false;
         colCount = board[0].length;

         for(int i=0; i < rowCount; ++i) {
            if(found) break;
            for(int j=0; j < colCount; ++j) {
               if(found) break;
               if(board[i][j]  == word.charAt(0)) {
                  Set<Integer> visited = new HashSet<Integer>();
                  visited.add(i * colCount + j);
                  dfs(board, i, j, word, 0, visited);
               }
            }
         }

         return found;
      }

      private void dfs(char[][] board, int i, int j, String word, int d, Set<Integer> visited) {
         if(d == word.length()-1) {
            found = true;
            return;
         }

         for(int ii=-1; ii <= 1; ++ii) {
            if(found) break;
            if(ii == 0) continue;
            int i2 = i + ii;
            if(i2 < 0 || i2 >= rowCount) continue;
            if(visited.contains(i2 * colCount + j) || board[i2][j] != word.charAt(d+1)) {
               continue;
            }
            dfs(board, i2, j, word, d+1, move(visited, i2, j));
         }

         for(int jj=-1; jj <= 1; ++jj) {
            if(found) break;
            if(jj == 0) continue;
            int j2 = j + jj;
            if(j2 < 0 || j2 >= colCount) continue;
            if(visited.contains(i * colCount + j2) || board[i][j2] != word.charAt(d+1)) {
               continue;
            }
            dfs(board, i, j2, word, d+1, move(visited, i, j2));
         }



      }

      private Set<Integer> move(Set<Integer> visited, int i, int j) {
         Set<Integer> newSet = new HashSet<Integer>(visited);
         newSet.add(i * colCount + j);
         return newSet;
      }


   }
}
