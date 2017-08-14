package com.github.chen0040.leetcode.day19.medium;


import java.util.Arrays;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 */
public class MinimumMovesToEqualArrayElementsII {
   public class Solution {
      public int minMoves2(int[] nums) {
         int sum = 0;

         Arrays.sort(nums);
         int mid = nums.length / 2;
         int mode = nums[mid];

         //int avg =sum / nums.length;
         int moves = 0;
         for(Integer i : nums) {
            moves += Math.abs(mode - i);
         }
         return moves;
      }
   }
}
