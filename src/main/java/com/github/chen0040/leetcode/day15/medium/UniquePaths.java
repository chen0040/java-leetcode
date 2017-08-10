package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
   public class Solution {
      public int uniquePaths(int m, int n) {
         m--;
         n--;

         double denom = factorial(n);
         if(m+1 <= m+n) {
            return (int)(factorial(m+1, m + n) / denom);
         } else {
            return (int)(factorial(m + n) / (denom * factorial(m)));
         }
      }

      private double factorial(int k, int n) {
         if(n<=k) return k;
         return n * factorial(k, n-1);
      }

      private double factorial(int n) {
         if(n <= 1) return 1;
         return n * factorial(n-1);
      }


   }
}
