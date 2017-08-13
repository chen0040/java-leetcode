package com.github.chen0040.leetcode.day06.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * link: https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
   public class Solution {
      public int searchInsert(int[] nums, int target) {
         int lo = 0;
         int hi = nums.length-1;
         while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) {
               lo = mid + 1;
            } else if(nums[mid] > target) {
               hi = mid - 1;
            } else {
               return mid;
            }
         }
         return lo;
      }
   }
}
