package com.github.chen0040.leetcode.day8.medium;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 3/8/2017.
 *
 * link: https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {
   public class Solution {
      public boolean isValidSudoku(char[][] grid) {
         for(int i=0; i < 3; ++i) {

            for(int j=0; j < 3; ++j) {
               Set<Character> exists = new HashSet<Character>();
               for(int k=0; k < 3; ++k) {
                  int row = i * 3 + k;
                  for(int k2 = 0; k2 < 3; ++k2) {
                     int col = j * 3 + k2;
                     char c = grid[row][col];
                     if(c != '.') {
                        if(exists.contains(c)) {
                           return false;
                        }
                        exists.add(c);
                     }
                  }
               }
            }
         }

         for(int i=0; i < 9; ++i) {
            Set<Character> exists1 = new HashSet<Character>();
            Set<Character> exists2 = new HashSet<Character>();
            for(int j=0; j < 9; ++j) {
               char c = grid[i][j];
               if(c != '.') {
                  if(exists1.contains(c)) {
                     return false;
                  }
                  exists1.add(c);
               }
               char c2 = grid[j][i];
               if(c2 != '.') {
                  if(exists2.contains(c2)) {
                     return false;
                  }
                  exists2.add(c2);
               }
            }
         }

         return true;
      }
   }
}
