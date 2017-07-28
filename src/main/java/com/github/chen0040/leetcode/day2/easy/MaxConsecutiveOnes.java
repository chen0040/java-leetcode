package com.github.chen0040.leetcode.day2.easy;


/**
 * Created by xschen on 28/7/2017.
 *
 *
 * summary:
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * link: https://leetcode.com/problems/max-consecutive-ones/tabs/description
 */
public class MaxConsecutiveOnes {
   public int findMaxConsecutiveOnes(int[] nums) {
      int sum = 0;
      int maxSum = 0;
      for(int i=0; i < nums.length; ++i){
         if(nums[i] == 1) {
            sum++;
         } else {
            maxSum = Math.max(sum, maxSum);
            sum = 0;
         }
      }
      maxSum = Math.max(sum, maxSum);
      return maxSum;
   }
}
