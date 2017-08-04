package com.github.chen0040.leetcode.day9.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * link: https://leetcode.com/problems/power-of-four/description/
 */
public class IsPowerOfFour {
   public class Solution {

      public boolean isPowerOfFour(int num) {
         return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
      }
   }
}
