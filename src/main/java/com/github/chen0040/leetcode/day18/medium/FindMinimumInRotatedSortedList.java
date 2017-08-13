package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumInRotatedSortedList {
   public class Solution {
      public int findMin(int[] nums) {
         int lo = 0;
         int hi = nums.length - 1;
         while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(mid > 0 && nums[mid] < nums[mid-1]) {
               return nums[mid];
            }
            if(nums[lo] <= nums[mid] && nums[mid] > nums[hi]) {
               lo = mid + 1;
            } else {
               hi = mid - 1;
            }
         }

         return nums[lo];
      }
   }
}
