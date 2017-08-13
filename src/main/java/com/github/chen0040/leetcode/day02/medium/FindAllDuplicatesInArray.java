package com.github.chen0040.leetcode.day02.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 * link: https://leetcode.com/problems/find-all-duplicates-in-an-array/tabs/description
 */
public class FindAllDuplicatesInArray {
   public class Solution {
      public List<Integer> findDuplicates(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < nums.length; ++i) {
            if(set.contains(nums[i])){
               result.add(nums[i]);
            } else {
               set.add(nums[i]);
            }
         }
         return result;
      }
   }
}
