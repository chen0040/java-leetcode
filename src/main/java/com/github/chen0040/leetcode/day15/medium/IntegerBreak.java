package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/integer-break/description/
 */
public class IntegerBreak {
   public class Solution {
      public int integerBreak(int n) {
         if(n == 2) return 1;
         if(n == 3) return 2;

         int product = 1;
         while(n > 4) {
            n -= 3;
            product *= 3;
         }

         product *= n;
         return product;
      }
   }
}
