package com.github.chen0040.leetcode.day16.medium;


import java.util.Arrays;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/valid-triangle-number/description/
 */
public class ValidTriangleNumber {
   public class Solution {
      public int triangleNumber(int[] nums) {
         int count = 0;
         Arrays.sort(nums);

         int hi = nums.length-1;
         while(hi > 1) {
            int lo = 0, j = hi - 1;
            while(lo < j) {
               if(nums[lo] + nums[j] <= nums[hi]) {
                  lo++;
               } else {
                  count += (j - lo);
                  j--;
               }
            }
            hi--;
         }

         return count;
      }
   }
}
