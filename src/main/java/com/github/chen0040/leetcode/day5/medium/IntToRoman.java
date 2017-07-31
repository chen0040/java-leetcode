package com.github.chen0040.leetcode.day5.medium;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * link: https://leetcode.com/problems/integer-to-roman/description/
 */
public class IntToRoman {
   public class Solution {
      public String intToRoman(int num) {
         String s = "";
         while(num > 0) {
            if(num >= 1000) {
               int m = num / 1000;
               for(int i=0; i < m; ++i) {
                  s += "M";
               }
               num = num % 1000;
            } else if(num >= 500) {
               if(num >= 900) {
                  s += "CM";
                  num -= 900;
               } else {
                  int m = num / 500;
                  for(int i=0; i < m; ++i) {
                     s += "D";
                  }
                  num = num % 500;
               }
            } else if(num >= 100) {
               if(num >= 400) {
                  s += "CD";
                  num -= 400;
               } else {
                  int m = num / 100;
                  for(int i = 0; i < m; ++i) {
                     s += "C";
                  }
                  num = num % 100;
               }
            } else if(num >= 50) {
               if(num >= 90) {
                  s += "XC";
                  num -= 90;
               } else {
                  int m = num / 50;
                  for(int i = 0; i < m; ++i) {
                     s += "L";
                  }
                  num = num % 50;
               }
            } else if(num >= 10) {
               if(num >= 40) {
                  s += "XL";
                  num -= 40;
               } else {
                  int m = num / 10;
                  for(int i=0; i < m; ++i) {
                     s += "X";
                  }
                  num = num % 10;
               }
            } else if(num >= 5) {
               if(num == 9) {
                  s += "IX";
                  num = 0;
               } else {
                  int m = num / 5;
                  for(int i=0; i < m; ++i) {
                     s += "V";
                  }
                  num = num % 5;
               }

            } else {
               if(num == 4) {
                  s += "IV";
                  num = 0;
               } else {
                  for(int i=0; i < num; ++i) {
                     s += "I";
                  }
               }
               num = 0;
            }
         }

         return s;


      }
   }
}
