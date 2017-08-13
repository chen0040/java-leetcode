package com.github.chen0040.leetcode.day04.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given an integer, return its base 7 string representation.
 *
 * link: https://leetcode.com/problems/base-7/description/
 */
public class Base7 {
   public class Solution {
      public String convertToBase7(int num) {
         if(num == 0) return "0";
         String s = "";
         boolean neg = num < 0;
         if(neg) num = -num;
         while(num > 0) {
            int digit = num % 7;
            s = digit + s;
            num /= 7;
         }
         if(neg) {
            s = "-" + s;
         }
         return s;
      }
   }
}
