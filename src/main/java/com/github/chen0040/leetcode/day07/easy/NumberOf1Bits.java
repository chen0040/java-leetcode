package com.github.chen0040.leetcode.day07.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * link: https://leetcode.com/problems/number-of-1-bits/description/
 */
public class NumberOf1Bits {
   public static void main(String[] args) {
      Solution s = new Solution();
      int output = s.hammingWeight(11);
      if(output == 3) {
         System.out.println("verified");
      } else {
         System.out.println(output);
      }
      output = s.hammingWeight( (int) 2147483648L);
      if(output == 1) {
         System.out.println("verified");
      } else {
         System.out.println(output);
      }
      output = s.hammingWeight((int)  4294967295L);
      if(output == 32) {
         System.out.println("verified");
      } else {
         System.out.println(output);
      }
   }
   public static class Solution {
      // you need to treat n as an unsigned value
      public int hammingWeight(int n) {


         int count = 0;
         for(int i=0; i < 32; ++i) {
            count += (n&1) > 0 ? 1 : 0;
            n >>= 1;
         }
         return count;
      }
   }
}
