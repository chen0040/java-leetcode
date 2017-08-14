package com.github.chen0040.leetcode.day19.easy;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 */
public class MinimumMovesToEqualArrayElements {
   public class Solution {
      public int minMoves(int[] nums) {
         int min = Integer.MAX_VALUE;
         for(int i=0; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
         }
         int sum = 0;
         for(Integer i : nums) {
            sum += (i - min);
         }
         return sum;

      }
   }
}
