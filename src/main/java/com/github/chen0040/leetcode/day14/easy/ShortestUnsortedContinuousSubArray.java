package com.github.chen0040.leetcode.day14.easy;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class ShortestUnsortedContinuousSubArray {
   public class Solution {
      public int findUnsortedSubarray(int[] nums) {
         int i = 0;
         int j = nums.length-1;
         int lower_bound = -1;
         boolean lower_bound_found = false;
         int upper_bound = nums.length;
         boolean upper_bound_found = false;
         while(!lower_bound_found || !upper_bound_found) {
            if(!lower_bound_found) {
               for(int k = i + 1; k <= j; ++k) {
                  if(nums[k] < nums[i]) {
                     lower_bound = i;
                     lower_bound_found = true;
                     break;
                  }
               }
               if(!lower_bound_found) {
                  i++;
               }
            }

            if(!upper_bound_found) {
               for(int k = j-1; k >= i; --k) {
                  if(nums[k] > nums[j]) {
                     upper_bound = j;
                     upper_bound_found = true;
                     break;
                  }
               }
               if(!upper_bound_found) {
                  j--;
               }
            }

            if(i >= j) {
               return 0;
            }
         }

         return upper_bound - lower_bound + 1;
      }
   }
}
