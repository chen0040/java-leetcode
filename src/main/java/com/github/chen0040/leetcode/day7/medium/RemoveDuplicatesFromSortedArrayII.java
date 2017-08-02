package com.github.chen0040.leetcode.day7.medium;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 * link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicatesFromSortedArrayII {
   public class Solution {
      public int removeDuplicates(int[] nums) {
         int newLength = nums.length;
         if(newLength < 3) return newLength;
         int prev = nums[0];
         for(int i=1; i < newLength - 1;) {
            if(prev == nums[i] && nums[i] == nums[i+1]) {
               newLength--;
               for(int j = i+1; j < newLength; ++j) {
                  nums[j] = nums[j+1];
               }
            } else {
               prev = nums[i];
               ++i;
            }
         }
         return newLength;
      }
   }
}
