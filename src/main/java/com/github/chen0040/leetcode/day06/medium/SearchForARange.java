package com.github.chen0040.leetcode.day06.medium;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * link: https://leetcode.com/problems/search-for-a-range/description/
 */
public class SearchForARange {
   public class Solution {
      public int[] searchRange(int[] nums, int target) {
         int lo = 0;
         int hi = nums.length - 1;
         int i=-1,j=-1;
         while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
               j = mid;
               i = mid;
               while(nums[j] == target) {

                  if(j >= nums.length-1) {
                     break;
                  }
                  if(nums[j+1] == target) {
                     j++;
                  } else {
                     break;
                  }
               }
               while(nums[i] == target) {
                  if(i <= 0) {
                     break;
                  }
                  if(nums[i-1] == target) {
                     i--;
                  } else {
                     break;
                  }
               }
               break;
            } else if(nums[mid] < target) {
               lo = mid + 1;
            } else {
               hi = mid - 1;
            }
         }

         int[] result = new int[2];
         result[0] = i;
         result[1] = j;
         return result;
      }
   }
}
