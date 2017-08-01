package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * link: https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaxSubarray {
   public class Solution {
      public int maxSubArray(int[] nums) {
         int maxSum = Integer.MIN_VALUE;
         int sum = 0;
         for(int i=0; i < nums.length; ++i) {
            if(nums[i] < 0) {
               if(sum + nums[i] < 0) {
                  sum = 0;
               } else {
                  sum += nums[i];
               }
            } else {
               sum += nums[i];
               maxSum = Math.max(sum, maxSum);
            }
         }


         for(int i=0; i < nums.length; ++i) {
            maxSum = Math.max(maxSum, nums[i]);
         }
         return maxSum;
      }
   }
}
