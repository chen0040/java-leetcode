package com.github.chen0040.leetcode.day09.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * link: https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQuery {
   public class NumArray {

      private int[] sums;
      private int[] nums_;
      public NumArray(int[] nums) {
         nums_ = nums;
         sums = new int[nums.length];
         int sum = 0;
         for(int i=0; i < nums.length; ++i) {
            sum += nums[i];
            sums[i] = sum;
         }
      }

      public int sumRange(int i, int j) {
         return sums[j] - sums[i] + nums_[i];
      }
   }
}
