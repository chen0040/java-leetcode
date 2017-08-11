package com.github.chen0040.leetcode.day16.medium;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class NextGreaterElementII {
   public class Solution {
      public int[] nextGreaterElements(int[] nums) {
         int[] result = new int[nums.length];
         for(int i=0; i < nums.length; ++i) {
            result[i]= -1;
            for(int j=1; j < nums.length; ++j) {
               int k = (i + j) % nums.length;
               if(nums[k] > nums[i]) {
                  result[i] = nums[k];
                  break;
               }
            }
         }

         return result;
      }
   }
}
