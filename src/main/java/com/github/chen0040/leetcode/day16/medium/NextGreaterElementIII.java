package com.github.chen0040.leetcode.day16.medium;


import java.util.Arrays;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/next-greater-element-iii/description/
 */
public class NextGreaterElementIII {
   public int nextGreaterElement(int n) {
      char[] nums = ("" + n).toCharArray();

      int index = -1;
      for(int j=nums.length-1; j > 0; --j) {
         if(nums[j-1] < nums[j]){
            index = j;
            break;
         }
      }

      if(index == -1) return -1;

      int smallest = index;
      for(int j = index+1; j < nums.length; ++j) {
         if(nums[j] > nums[index-1]) {
            smallest = j;
         }
      }

      exchange(nums, smallest, index-1);
      Arrays.sort(nums, index, nums.length);

      long res = Long.parseLong(new String(nums));
      return res <= Integer.MAX_VALUE ? (int)res : -1;
   }

   private void exchange(char[] nums, int i, int j) {
      char temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }
}
