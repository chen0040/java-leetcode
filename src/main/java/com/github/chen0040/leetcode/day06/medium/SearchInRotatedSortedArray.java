package com.github.chen0040.leetcode.day06.medium;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
   public class Solution {
      public int search(int[] nums, int target) {
         int lo = 0;
         int hi = nums.length - 1;
         while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
               return mid;
            } else if(nums[mid] < target) {
               if(nums[mid] < nums[lo]) { // the split is at lower half
                  if(target >= nums[lo]) {
                     hi = mid - 1;
                  } else {
                     lo = mid + 1;
                  }
               } else { // the split is at the upper half
                  lo = mid+1;
               }
            } else {
               if(nums[mid] > nums[hi]) { // the split is at upper half
                  if(target <= nums[hi]) {
                     lo = mid + 1;
                  } else {
                     hi = mid - 1;
                  }
               } else { // the split is at the lower half
                  hi = mid - 1;
               }
            }
         }
         return -1;
      }
   }
}
