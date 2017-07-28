package com.github.chen0040.leetcode.day2.medium;


import java.util.Random;


/**
 * Created by xschen on 28/7/2017.
 */
public class ShuffleAnArray {
   public class Solution {
      private int[] backup;
      private Random random = new Random();
      public Solution(int[] nums) {
         backup = new int[nums.length];
         for(int i=0; i < nums.length; ++i) {
            backup[i] = nums[i];
         }
      }

      /** Resets the array to its original configuration and return it. */
      public int[] reset() {
         int[] nums = new int[backup.length];
         for(int i=0; i < backup.length; ++i) {
            nums[i] = backup[i];
         }
         return nums;
      }

      /** Returns a random shuffling of the array. */
      public int[] shuffle() {
         int[] nums = reset();
         for(int i=0; i < backup.length; ++i) {
            int j = random.nextInt(i+1);
            exchange(nums, i, j);
         }
         return nums;
      }

      private void exchange(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
      }
   }
}
