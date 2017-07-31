package com.github.chen0040.leetcode.day5.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * link: https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {
   public class Solution {
      public int reverse(int x) {
         boolean neg = x < 0;
         if(neg && x == Integer.MIN_VALUE) return 0;
         if(neg) x = -x;

         int result = 0;
         while(x > 0) {
            int digit = x % 10;
            if(result + digit < result) {
               return 0;
            }
            result += digit;
            x /= 10;
            if(x > 0) {
               for(int i = 2; i <= 10; ++i) {
                  if(result * i < result) {
                     return 0;
                  }
               }
               result *= 10;
            }
            if(result < 0) {
               return 0;
            }
         }

         return neg ? -result : result;

      }
   }
}
