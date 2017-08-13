package com.github.chen0040.leetcode.day06.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArray {
   public class Solution {
      public int removeDuplicates(int[] nums) {
         int newLength = nums.length;
         for(int i=0; i < nums.length; ++i){
            if(i >= newLength-1) {
               break;
            }
            while(i != nums.length-1 && nums[i] == nums[i+1]) {
               newLength--;

               for(int j=i+1; j < newLength; ++j) {
                  nums[j] = nums[j+1];
               }
               if(i == newLength-1) {
                  break;
               }
            }

         }
         return newLength;
      }
   }
}
