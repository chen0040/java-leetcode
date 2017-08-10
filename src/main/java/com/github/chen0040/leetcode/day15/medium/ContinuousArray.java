package com.github.chen0040.leetcode.day15.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/contiguous-array/description/
 */
public class ContinuousArray {
   public class Solution {
      public int findMaxLength(int[] nums) {
         Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
         for(int i=0; i < nums.length; ++i) {
            if(nums[i] == 0) nums[i] = -1;
         }
         int sum = 0;
         int maxLength = 0;
         sums.put(0, -1);
         for(int i=0; i < nums.length; ++i) {
            sum += nums[i];
            if(sums.containsKey(sum)) {
               maxLength = Math.max(maxLength, i - sums.get(sum) );
            } else {
               sums.put(sum, i);
            }
         }
         return maxLength;
      }

   }
}
