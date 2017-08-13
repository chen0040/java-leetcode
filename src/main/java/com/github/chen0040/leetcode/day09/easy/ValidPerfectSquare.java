package com.github.chen0040.leetcode.day09.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * link: https://leetcode.com/problems/valid-perfect-square/description/
 */
public class ValidPerfectSquare {
   public class Solution {
      public boolean isPerfectSquare(int num) {
         int lo = 1;
         int hi = num;
         while(lo <= hi) {
            double mid = (lo + hi) / 2;
            double sq = num / mid;
            if(mid > sq) {
               hi = (int)mid - 1;
            } else if(mid < sq) {
               lo = (int)mid + 1;
            } else  {
               return true;
            }
         }
         return false;
      }
   }
}
