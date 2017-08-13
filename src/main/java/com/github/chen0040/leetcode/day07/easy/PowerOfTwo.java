package com.github.chen0040.leetcode.day07.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given an integer, write a function to determine if it is a power of two.
 *
 * link: https://leetcode.com/problems/power-of-two/description/
 */
public class PowerOfTwo {
   public class Solution {
      public boolean isPowerOfTwo(int n) {
         if(n <= 0) return false;
         return (n & (n-1)) == 0;
      }
   }
}
