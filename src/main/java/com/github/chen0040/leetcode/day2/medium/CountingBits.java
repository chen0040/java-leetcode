package com.github.chen0040.leetcode.day2.medium;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * link: https://leetcode.com/problems/counting-bits/tabs/description
 */
public class CountingBits {
   public int[] countBits(int num) {
      int[] result = new int[num+1];
      for(int val=0; val <= num; ++val) {
         result[val] = countBit(val);
      }
      return result;
   }

   private int countBit(int val) {
      int count = 0;
      while(val > 0){
         count += (val&1) > 0 ? 1 : 0;
         val >>= 1;
      }
      return count;
   }
}
