package com.github.chen0040.leetcode.day6.medium;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * link: https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {
   public class Solution {
      private int partition(int[] nums, int lo, int hi) {
         int i=lo, j = hi+1;
         int v = nums[lo];
         while(true) {
            while(v > nums[++i]) {
               if(i >= hi) break;
            }
            while(v < nums[--j]) {
               if(j <= lo) break;
            }

            if(i >= j) break;
            exchange(nums, i, j);
         }
         exchange(nums, lo, j);
         return j;
      }

      private void exchange(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
      }

      private void quickSort(int[] nums, int lo, int hi) {
         if(lo >= hi) return;
         int j = partition(nums, lo, hi);
         quickSort(nums, lo, j-1);
         quickSort(nums, j+1, hi);
      }
      public void sortColors(int[] nums) {
         quickSort(nums, 0, nums.length-1);
      }
   }
}
