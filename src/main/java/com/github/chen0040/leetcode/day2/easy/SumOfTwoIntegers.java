package com.github.chen0040.leetcode.day2.easy;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * link: https://leetcode.com/problems/sum-of-two-integers/tabs/description
 */
public class SumOfTwoIntegers {
   public class Solution {
      public int getSum(int a, int b) {
         while (b != 0){
            int carry = (a & b) ;

            a = a ^ b;

            b = carry << 1;
         }
         return a;
      }
   }
}
