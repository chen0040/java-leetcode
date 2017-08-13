package com.github.chen0040.leetcode.day04.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * link: https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
   public class Solution {
      public int findTargetSumWays(int[] nums, int S) {
         return findTargetSumWays(nums, S, 0, 0);
      }

      public int findTargetSumWays(int[] nums, int S, int sum, int d) {
         if(d == nums.length) {
            return sum == S ? 1 : 0;
         }

         int count1 = findTargetSumWays(nums, S, sum + nums[d], d+1);
         int count2 = findTargetSumWays(nums, S, sum - nums[d], d+1);
         return count1 + count2;
      }
   }
}
