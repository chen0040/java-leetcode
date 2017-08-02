package com.github.chen0040.leetcode.day7.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * link: https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class ContainsDuplicateII {
   public class Solution {
      public boolean containsNearbyDuplicate(int[] nums, int k) {
         Map<Integer, Integer> states = new HashMap<Integer, Integer>();
         for(int i=0 ; i < nums.length; ++i) {
            int num = nums[i];
            if(states.containsKey(num) && i - states.get(num) <= k){
               return true;
            }
            states.put(num, i);
         }
         return false;
      }
   }
}
