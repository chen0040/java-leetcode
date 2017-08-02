package com.github.chen0040.leetcode.day7.easy;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * link: https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {
   public class Solution {
      public void rotate(int[] nums, int k) {
         if(nums.length == 0) return;
         int count = nums.length;
         if(k > count) {
            k = k % count;
         }
         for(int m = 0; m < count - k; ++m) {
            int temp = nums[0];
            for(int i = 1; i < nums.length; ++i) {
               nums[i-1] = nums[i];
            }
            nums[nums.length-1] = temp;
         }
      }

      public void rotate2(int[] nums, int k) {
         if(nums.length == 0) return;
         if(k > nums.length) {
            k %= nums.length;
         }
         for(int m = 0; m < k; ++m){
            int temp = nums[nums.length-1];
            for(int i=nums.length-2; i >= 0; --i) {
               nums[i+1] = nums[i];
            }
            nums[0] = temp;
         }
      }

      public void rotate1(int[] nums, int k) {
         if(nums.length == 0) return;
         List<Integer> buffer = new ArrayList<Integer>();
         if(k > nums.length){
            k %= nums.length;
         }
         for(int i=k-1; i >= 0; --i) {
            buffer.add(nums[nums.length-1 - i]);
         }

         for(int i=nums.length-k-1; i >= 0; --i) {
            nums[i+k] = nums[i];
         }

         for(int i=0; i < k; ++i) {
            nums[i] = buffer.get(i);
         }
      }
   }
}
