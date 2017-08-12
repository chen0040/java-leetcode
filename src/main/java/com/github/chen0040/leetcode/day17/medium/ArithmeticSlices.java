package com.github.chen0040.leetcode.day17.medium;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/arithmetic-slices/description/
 */
public class ArithmeticSlices {
   public class Solution {
      private int sumCount(int n) {
         if(n <= 1) return 1;
         return n + sumCount(n-1);
      }
      public int numberOfArithmeticSlices(int[] A) {
         int count = 0;
         int result = 0;
         int prevDiff = Integer.MIN_VALUE;
         for(int i=1; i < A.length; ++i) {
            int diff = A[i] - A[i-1];
            if(diff == prevDiff) {
               count++;
            } else {
               if(count >= 2) {
                  result += sumCount(count-1);
               }
               count = 1;

            }
            prevDiff = diff;
         }

         if(count >= 2) {
            result += sumCount(count-1);
         }

         return result;

      }
   }
}
