package com.github.chen0040.leetcode.day7.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumsSortedArray {
   public class Solution {
      public int[] twoSum(int[] numbers, int target) {
         Map<Integer, Integer> states = new HashMap<Integer, Integer>();
         for(int i=0; i < numbers.length; ++i) {
            int num = numbers[i];
            if(states.containsKey(num)){
               return new int[] { states.get(num) + 1, i + 1 };
            }
            int key = target - num;
            states.put(key, i);
         }
         return new int[0];
      }
   }
}
