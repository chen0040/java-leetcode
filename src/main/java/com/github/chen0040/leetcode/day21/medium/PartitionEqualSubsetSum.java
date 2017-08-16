package com.github.chen0040.leetcode.day21.medium;


import java.util.Arrays;


/**
 * Created by xschen on 16/8/2017.
 *
 * link: https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {
   public class Solution {
      public boolean canPartition(int[] nums) {
         if(nums.length == 1) return false;
         Arrays.sort(nums);
         int sum = 0;
         for(int i=0; i < nums.length; ++i){
            sum+=nums[i];
         }
         if(sum % 2 == 1) return false;
         sum /= 2;
         boolean[] dp = new boolean[sum+1];
         dp[0] = true;
         for(int i = 1; i < nums.length; ++i) {
            for(int j=sum; j >= nums[i-1]; j--) {
               dp[j] = dp[j] || dp[j - nums[i-1]];
            }
         }

         return dp[sum];

      }
   }
}
