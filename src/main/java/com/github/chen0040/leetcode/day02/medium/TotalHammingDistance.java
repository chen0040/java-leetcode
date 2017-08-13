package com.github.chen0040.leetcode.day02.medium;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * link: https://leetcode.com/problems/total-hamming-distance/tabs/description
 */
public class TotalHammingDistance {
   public class Solution {
      public int totalHammingDistance(int[] nums) {
         int distance = 0;
         for(int i=0; i < 32; ++i) {
            int masked = 1 << i;
            int ones = 0;
            int zeros = 0;
            for(int j=0; j < nums.length; ++j) {
               if((nums[j] & masked) > 0){
                  ones++;
               } else {
                  zeros++;
               }

            }
            distance += ones  * zeros;
         }
         return distance;
      }


   }
}
