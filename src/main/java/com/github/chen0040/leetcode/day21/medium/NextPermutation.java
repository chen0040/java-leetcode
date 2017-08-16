package com.github.chen0040.leetcode.day21.medium;


import java.util.Arrays;


/**
 * Created by xschen on 16/8/2017.
 *
 * link: https://leetcode.com/problems/next-permutation/description/
 */
public class NextPermutation {
   public class Solution {
      public void nextPermutation(int[] nums) {
         int k = nums.length-1;

         while(k > 0) {
            if(nums[k-1] < nums[k]) {
               break;
            }
            k--;
         }

         if(k == 0) {
            Arrays.sort(nums);
            return;
         }

         int selected = k;
         for(int j = k; j < nums.length; j++) {
            if(nums[j] > nums[k-1]) {
               selected = j;
            }
         }

         int temp = nums[selected];
         nums[selected] = nums[k-1];
         nums[k-1] = temp;

         Arrays.sort(nums, k, nums.length);
      }


   }
}
