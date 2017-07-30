package com.github.chen0040.leetcode.day4.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 30/7/2017.
 *
 * Summary:
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * link: https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
   public class Solution {
      public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> sets = new ArrayList<List<Integer>>();
         sets.add(new ArrayList<Integer>());
         collect(nums, sets, 0);
         return sets;
      }

      private void collect(int[] nums, List<List<Integer>> sets, int d) {
         if(d == nums.length) {
            return;
         }

         int val = nums[d];
         List<List<Integer>> newSets = new ArrayList<List<Integer>>();
         for(int i = 0; i < sets.size(); ++i) {
            List<Integer> subset = insert(sets.get(i), val);
            newSets.add(subset);
         }
         sets.addAll(newSets);

         collect(nums, sets, d+1);
      }

      private List<Integer> insert(List<Integer> set, int val) {
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < set.size(); ++i) {
            result.add(set.get(i));
         }
         result.add(val);
         return result;
      }
   }
}
