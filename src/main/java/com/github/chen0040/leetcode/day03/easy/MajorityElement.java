package com.github.chen0040.leetcode.day03.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * link: https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {
   public class Solution {
      public int majorityElement(int[] nums) {
         Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
         int threshold = (int)Math.ceil(nums.length / 2.0);
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if(counts.get(num) >= threshold) {
               return num;
            }
         }
         return -1;
      }
   }
}
