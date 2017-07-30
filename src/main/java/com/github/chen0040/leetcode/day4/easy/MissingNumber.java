package com.github.chen0040.leetcode.day4.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * link: https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {
   public class Solution {
      public int missingNumber(int[] nums) {
         int n = nums.length;
         int sum = (n+1) * n / 2;
         for(int i=0; i < n; ++i) {
            sum -= nums[i];
         }
         return sum;
      }
   }
}
