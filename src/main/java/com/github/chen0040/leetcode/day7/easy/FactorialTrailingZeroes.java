package com.github.chen0040.leetcode.day7.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * link: https://leetcode.com/problems/factorial-trailing-zeroes/description/
 */
public class FactorialTrailingZeroes {
   public class Solution {
      public int trailingZeroes(int n) {
         int count = 0;
         while(n > 0) {
            n /= 5;
            count += n;
         }
         return count;
      }
   }
}
