package com.github.chen0040.leetcode.day9.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 *
 * link: https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes {
   public class Solution {
      public void moveZeroes(int[] nums) {
         int j = 0;
         for(int i=0; i < nums.length; i++) {
            if(nums[i] == 0) {
               j = Math.max(j, i+1);
               while(j < nums.length && nums[j]==0){
                  j++;
               }
               if(j == nums.length) {
                  break;
               }
               exchange(nums, i, j);
            }
         }

      }

      private void exchange(int[] a, int i, int j) {
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }
   }
}
