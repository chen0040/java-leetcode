package com.github.chen0040.leetcode.day8.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * link: https://leetcode.com/problems/third-maximum-number/description/
 */
public class ThirdMax {
   public class Solution {
      public int thirdMax(int[] nums) {
         int[] values = new int[3];
         for(int i=0; i < 3; ++i) {
            values[i] = Integer.MIN_VALUE;
         }

         Set<Integer> set = new HashSet<Integer>();
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];
            if(set.contains(num)) continue;
            set.add(num);
            if(num >= values[0]){
               values[2] = values[1];
               values[1] = values[0];
               values[0] = num;
            } else if(num >= values[1]) {
               values[2] = values[1];
               values[1] = num;
            } else if(num >= values[2]) {
               values[2] = num;
            }
         }

         if(values[2] == Integer.MIN_VALUE && set.size() < 3) return values[0];

         return values[2];
      }
   }
}
