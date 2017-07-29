package com.github.chen0040.leetcode.day3.easy;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * link: https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumbers {
   public class Solution {
      public int titleToNumber(String s) {
         int start = (int)'A';
         int result = 0;
         for(int i = 0; i < s.length(); ++i) {
            int c = (int)s.charAt(i);
            c = c - start + 1;
            result = result * 26 + c;
         }
         return result;
      }
   }
}
