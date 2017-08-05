package com.github.chen0040.leetcode.day10.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * 
 * link: https://leetcode.com/problems/set-mismatch/description/
 */
public class SetMismatch {
   public class Solution {
      public int[] findErrorNums(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         int number_duplicated = -1;
         for(int i=0; i < nums.length; ++i) {
            if(set.contains(nums[i])) {
               number_duplicated = nums[i];
            }
            set.add(nums[i]);
         }
         int n = nums.length;
         int number_missing = -1;
         for(int i = 1; i <= n; ++i) {
            if(!set.contains(i)){
               number_missing = i;
               break;
            }
         }
         return new int[]{number_duplicated, number_missing};
      }
   }
}
