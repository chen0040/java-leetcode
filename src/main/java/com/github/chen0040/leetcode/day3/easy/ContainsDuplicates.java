package com.github.chen0040.leetcode.day3.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * link: https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicates {
   public class Solution {
      public boolean containsDuplicate(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         for(int i=0; i < nums.length; ++i) {
            int key = nums[i];
            if(set.contains(key)) {
               return true;
            }
            set.add(key);
         }
         return false;
      }
   }
}
