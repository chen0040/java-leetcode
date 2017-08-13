package com.github.chen0040.leetcode.day02.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * link: https://leetcode.com/problems/single-number/tabs/description
 */
public class SingleNumber {
   public class Solution {
      public int singleNumber(int[] nums) {
         Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

         for(int i=0; i < nums.length; ++i) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
         }
         for(int i=0; i < nums.length; ++i) {
            if(counts.get(nums[i]) == 1) {
               return nums[i];
            }
         }
         return 0;
      }
   }
}
