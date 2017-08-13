package com.github.chen0040.leetcode.day06.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * link: https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {
   public class Solution {
      public int removeElement(int[] nums, int val) {
         if(nums.length == 0) return nums.length;
         int i = 0;
         int k = nums.length-1;

         while(i <= k) {
            while(nums[k] == val) {
               k--;
               if(k < 0) break;
            }
            if(k < 0) return 0;
            if(nums[i] == val && k > i) {
               exchange(nums, i++, k--);
            } else {
               i++;
            }
         }
         return k+1;
      }

      private void exchange(int[] a, int i, int j) {
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }
   }
}
