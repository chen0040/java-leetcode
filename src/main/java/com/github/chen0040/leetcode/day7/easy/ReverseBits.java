package com.github.chen0040.leetcode.day7.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * link: https://leetcode.com/problems/reverse-bits/description/
 */
public class ReverseBits {
   public static void main(String[] args) {
      Solution s = new Solution();
      int output = s.reverseBits(43261596);
      if(output == 964176192) {
         System.out.println("verified");
      } else {
         System.out.println(output + " not matched");
      }
   }
   public static class Solution {
      // you need treat n as an unsigned value
      public int reverseBits(int n) {
         int result = 0;
         for(int i=0; i < 32; ++i) {
            result <<= 1;
            result += (n&1) > 0 ? 1 : 0;
            n >>= 1;
         }
         return result;
      }
   }
}
