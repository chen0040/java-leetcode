package com.github.chen0040.leetcode.day7.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * link: https://leetcode.com/problems/permutations-ii/description/
 */
public class PermutationsII {
   public class Solution {
      public List<List<Integer>> permuteUnique(int[] nums) {
         Set<List<Integer>> perms = new HashSet<List<Integer>>();
         perms.add(new ArrayList<Integer>());
         return new ArrayList<List<Integer>>(permute(perms, nums, 0));
      }

      private Set<List<Integer>> permute(Set<List<Integer>> perms, int[] nums, int d) {
         if(d == nums.length) {
            return perms;
         }

         int element = nums[d];

         Set<List<Integer>> newSet = new HashSet<List<Integer>>();
         for(List<Integer> perm : perms) {
            List<List<Integer>> newPerms = generate(perm, element);
            newSet.addAll(newPerms);
         }
         return permute(newSet, nums, d+1);
      }

      private List<List<Integer>> generate(List<Integer> perm, int element) {
         List<List<Integer>> newSet = new ArrayList<List<Integer>>();
         for(int i=0; i < perm.size(); ++i) {
            List<Integer> p = insert(perm, element, i);
            newSet.add(p);
         }
         newSet.add(insert(perm, element, perm.size()));
         return newSet;

      }

      private List<Integer> insert(List<Integer> perm, int element, int i) {
         List<Integer> p = new ArrayList<Integer>();
         for(int j=0; j < perm.size(); ++j){
            if(i == j) {
               p.add(element);
            }
            p.add(perm.get(j));
         }
         if(i == perm.size()) {
            p.add(element);
         }
         return p;
      }
   }
}
