package com.github.chen0040.leetcode.day2.easy;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * link: https://leetcode.com/problems/next-greater-element-i/tabs/description
 */
public class NextGreaterElementI {

   public class Solution {
      public int[] nextGreaterElement(int[] findNums, int[] nums) {
         int[] result = new int[findNums.length];
         for(int i=0; i < findNums.length; ++i) {
            int num1 = findNums[i];
            int num2 = -1;
            boolean found = false;
            for(int j=0; j < nums.length; ++j) {
               if(nums[j] == num1) {
                  found = true;
               }
               if(found) {
                  if(nums[j] > num1) {
                     num2 = nums[j];
                     break;
                  }
               }
            }
            result[i]= num2;

         }
         return result;
      }
   }
}
