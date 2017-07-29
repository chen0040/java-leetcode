package com.github.chen0040.leetcode.day1.medium;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 *
 * link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleElementInSortedArray {
   public class Solution {
      public int singleNonDuplicate(int[] nums) {
         int low = 0;
         int high = nums.length - 1;
         while(low < high) {
            int mid = (high + low) / 2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
               return nums[mid];
            else if(nums[mid] == nums[mid+1] && mid % 2 == 0)
               low = mid+1;
            else if(nums[mid] == nums[mid-1] && mid % 2 == 1)
               low = mid+1;
            else
               high = mid-1;
         }
         return nums[low];
      }


   }
}
