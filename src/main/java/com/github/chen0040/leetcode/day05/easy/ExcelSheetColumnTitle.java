package com.github.chen0040.leetcode.day05.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * link: https://leetcode.com/problems/excel-sheet-column-title/description/
 */
public class ExcelSheetColumnTitle {
   public class Solution {
      public String convertToTitle(int n) {
         String result = "";
         int int_A = (int)'A';
         while(n > 0) {
            int digit = n % 26;
            n /= 26;
            if(digit == 0) {
               n--;
               digit = 26;
            }
            char c = (char)(int_A + digit - 1);
            result = c + result;
         }

         return result;
      }
   }
}
