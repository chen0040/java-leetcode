package com.github.chen0040.leetcode.day5.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Compute and return the square root of x.
 *
 * link: https://leetcode.com/problems/sqrtx/description/
 */
public class SqrtX {
   public class Solution {
      public int mySqrt(int x) {
         if(x == 0 || x == 1) return x;
         if(x < 0) {
            throw new ArithmeticException("square root of neg is not allowed");
         }
         int lo = 0, hi = x, result = 0;
         while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int test = mid;
            if(test > x / mid) {
               hi = mid - 1;
            } else if(test < x / mid) {
               result = mid;
               lo = mid + 1;

            } else {
               return mid;
            }
         }
         return result;
      }
   }
}
