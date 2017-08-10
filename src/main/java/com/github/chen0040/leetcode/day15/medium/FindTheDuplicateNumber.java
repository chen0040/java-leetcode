package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {
   public class Solution {
      public int findDuplicate(int[] nums) {
         int n = nums.length-1;
         boolean[] exists = new boolean[n+1];
         for(int i=0; i < nums.length; ++i) {
            if(exists[nums[i]]) {
               return nums[i];
            }
            exists[nums[i]] = true;
         }
         return -1;
      }
   }
}
