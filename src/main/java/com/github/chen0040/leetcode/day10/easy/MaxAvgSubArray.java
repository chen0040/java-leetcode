package com.github.chen0040.leetcode.day10.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * link: https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class MaxAvgSubArray {
   public class Solution {
      public double findMaxAverage(int[] nums, int k) {
         int count = 0;
         int sum = 0;
         double maxAvg = -10000;
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];
            sum += num;
            if(i >= k-1) {
               maxAvg = Math.max(maxAvg,(double)sum / k);
               sum -= nums[i - k + 1];
            }
         }

         return maxAvg;
      }
   }
}
