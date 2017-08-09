package com.github.chen0040.leetcode.day14.easy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
 * link: https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 */
public class KDiffPairsInArray {
   public class Solution {
      public int findPairs(int[] nums, int k) {
         Arrays.sort(nums);
         Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];
            int num2 = k + num;
            if(map.containsKey(num)) {
               map.put(num, true);
            }
            if(!map.containsKey(num2)) {
               map.put(num2, false);
            }
         }
         int count = 0;
         for(Boolean flag : map.values()) {
            count += (flag ? 1 : 0);
         }
         return count;
      }
   }
}
