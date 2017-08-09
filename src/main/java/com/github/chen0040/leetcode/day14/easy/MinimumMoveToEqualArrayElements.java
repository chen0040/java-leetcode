package com.github.chen0040.leetcode.day14.easy;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 */
public class MinimumMoveToEqualArrayElements {
   public class Solution {
      public int minMoves(int[] nums) {

         int min = nums[0];
         for(Integer num : nums) {
            min = Math.min(min, num);
         }

         int result = 0;
         for(Integer num : nums) {
            result += (num - min);
         }

         return result;

      }
   }
}
