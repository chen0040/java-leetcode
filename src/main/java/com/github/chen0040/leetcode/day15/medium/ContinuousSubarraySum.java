package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/continuous-subarray-sum/description/
 */
public class ContinuousSubarraySum {
   public class Solution {
      public boolean checkSubarraySum(int[] nums, int k) {

         int sum = 0;
         int[] sums = new int[nums.length];
         for(int i=0; i < nums.length; ++i) {
            sum += nums[i];
            sums[i] = sum;
         }
         for(int i=0; i < nums.length-1; ++i) {
            int sum1 = sums[i];
            for(int j=i+1; j < nums.length; ++j) {
               int sum2 = sums[j];
               sum = sum2 - sum1 + nums[i];
               if(k == 0){
                  return sum == 0;
               }
               if(sum % k == 0) return true;
            }
         }
         return false;
      }
   }
}
