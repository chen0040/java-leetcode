package com.github.chen0040.leetcode.day02.medium;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * link: https://leetcode.com/problems/single-number-iii/tabs/description
 */
public class SingleNumberIII {
   public class Solution {
      public int[] singleNumber(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         for(int i=0; i < nums.length; ++i) {
            if(set.contains(nums[i])) {
               set.remove(nums[i]);
            } else {
               set.add(nums[i]);
            }
         }
         int[] count = new int[set.size()];
         int index = 0;
         for(Integer val : set) {
            count[index++] = val;
         }
         return count;
      }
   }
}
