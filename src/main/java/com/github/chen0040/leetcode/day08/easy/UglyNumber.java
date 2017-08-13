package com.github.chen0040.leetcode.day08.easy;


/**
 * Created by xschen on 3/8/2017.
 *
 * summary:
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 *
 * link: https://leetcode.com/problems/ugly-number/description/
 */
public class UglyNumber {
   public class Solution {
      public boolean isUgly(int num) {
         int[] uprimes = new int[] { 2, 3, 5 };
         if(num == 1) return true;
         if(num <= 0) return false;
         while(num > 1) {
            int divisor = -1;
            for(int i=0; i < uprimes.length; ++i) {
               if(num % uprimes[i] == 0) {
                  divisor = uprimes[i];
                  break;
               }
            }
            if(divisor == -1) return false;
            num /= divisor;
         }
         return true;
      }
   }
}
