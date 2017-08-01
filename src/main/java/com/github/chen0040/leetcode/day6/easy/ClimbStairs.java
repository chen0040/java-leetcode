package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * link: https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbStairs {
   public class Solution {

      public int climbStairs(int n) {
         int count2 = 0;
         int count1 = 0;
         double ways = 0;
         for(int i=2; i <= n; i+=2) {
            count2++;
            count1 = n - i;
            ways += factorial(count1 + count2) / (factorial(count1) * factorial(count2));
         }
         ways += 1;
         return (int)ways;
      }

      private double factorial(int n) {
         if(n <= 1) return 1;
         return n * factorial(n-1);
      }

      private double factorial(int n, int k) {
         if(n <= k+1) return k+1;
         return n * factorial(n-1);
      }

   }
}
