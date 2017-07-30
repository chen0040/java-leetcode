package com.github.chen0040.leetcode.day4.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * link: https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {
   public class Solution {
      public int subarraySum(int[] nums, int k) {
         int count = 0;
         for(int i=0; i < nums.length; ++i) {
            int sum = k;
            for(int j=i; j < nums.length; ++j) {
               sum -= nums[j];
               if(sum == 0) {
                  count++;
               }
            }
         }
         return count;
      }
   }
}
