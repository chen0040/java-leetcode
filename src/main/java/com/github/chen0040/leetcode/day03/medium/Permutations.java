package com.github.chen0040.leetcode.day03.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * link: https://leetcode.com/problems/permutations/description/
 */
public class Permutations {
   public class Solution {
      public List<List<Integer>> generate(List<Integer> set, int val) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         for(int i=0; i < set.size(); ++i) {

            result.add(insert(set, val, i));
         }
         result.add(insert(set, val, set.size()));
         return result;
      }

      private List<Integer> insert(List<Integer> set, int val, int i) {
         List<Integer> list = new ArrayList<Integer>();
         for(int j=0; j < set.size(); ++j) {
            if(i==j) {
               list.add(val);
            }
            list.add(set.get(j));
         }
         if(i == set.size()) {
            list.add(val);
         }
         return list;
      }

      public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> set = new ArrayList<List<Integer>>();
         set.add(new ArrayList<Integer>());
         return permutate(nums, 0, set);

      }

      private List<List<Integer>> permutate(int[] nums, int d, List<List<Integer>> set) {
         if(d == nums.length) {
            return set;
         }
         int num = nums[d];
         List<List<Integer>> newSet = new ArrayList<List<Integer>>();

         for(List<Integer> seq : set) {
            List<List<Integer>> newSequences = generate(seq, num);
            newSet.addAll(newSequences);
         }
         return permutate(nums, d+1, newSet);
      }
   }
}
