package com.github.chen0040.leetcode.day9.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given an integer, write a function to determine if it is a power of three.
 *
 * link: https://leetcode.com/problems/power-of-three/description/
 */
public class IsPowerOfThree {
   public class Solution {
      public boolean isPowerOfThree(int n) {
         return n > 0 || ((int)Math.pow(3, 19)) % n == 0;
      }
   }
}
