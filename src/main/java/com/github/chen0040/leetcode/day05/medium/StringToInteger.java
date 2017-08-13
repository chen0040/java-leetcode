package com.github.chen0040.leetcode.day05.medium;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Implement atoi to convert a string to an integer.
 *
 * link: https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {
   public class Solution {
      private int REMOVE_SPACE = 0;
      private int CHECK_SIGN = 1;
      private int PARSE_DIGITS= 2;
      public int myAtoi(String str) {
         int sign = 1, total = 0;
         if(str.length() == 0) return 0;

         int signCount = 0;

         int step = REMOVE_SPACE;
         for(int index=0; index < str.length(); ++index) {
            if(step == REMOVE_SPACE) {
               if(str.charAt(index) == ' ') {
                  // skip
               } else {
                  step = CHECK_SIGN;
               }
            }

            if(step == CHECK_SIGN) {
               if(str.charAt(index) == '+' || str.charAt(index) == '-'){
                  if(signCount == 0){
                     sign = str.charAt(index) == '+' ? 1 : -1;
                     signCount++;
                  } else {
                     step = PARSE_DIGITS;
                  }
               } else {
                  step = PARSE_DIGITS;
               }
            }

            if(step == PARSE_DIGITS) {
               int digit = str.charAt(index) - '0';
               if(digit < 0 || digit > 9) break;

               if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                  return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

               total = 10 * total + digit;
            }
         }
         return total * sign;
      }
   }
}
