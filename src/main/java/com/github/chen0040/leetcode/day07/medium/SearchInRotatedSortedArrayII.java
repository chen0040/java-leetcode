package com.github.chen0040.leetcode.day07.medium;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 *
 * link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 */
public class SearchInRotatedSortedArrayII {
   public class Solution {
      public boolean search(int[] nums, int target) {
         int lo = 0;
         int hi = nums.length - 1;
         while(lo <= hi){
            while(lo < hi && nums[lo] == nums[hi]){
               lo++;
            }

            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
               return true;
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
         return false;
      }
   }
}
