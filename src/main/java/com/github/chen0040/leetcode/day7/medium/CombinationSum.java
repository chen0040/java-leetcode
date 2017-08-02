package com.github.chen0040.leetcode.day7.medium;


import java.util.*;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * link: https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {
   public class Solution {
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
         Set<List<Integer>> result = new HashSet<List<Integer>>();
         generate(result, candidates, target, new ArrayList<Integer>(), 0);
         return new ArrayList<List<Integer>>(result);
      }

      private void generate(Set<List<Integer>> set, int[] candidates, int target, List<Integer> solution, int currentSum) {
         if(currentSum == target) {
            Collections.sort(solution);
            set.add(solution);
            return;
         }
         if(currentSum > target) {
            return;
         }

         for(int i=0; i < candidates.length; ++i) {
            List<Integer> newSolution = append(solution, candidates[i]);
            generate(set, candidates, target, newSolution, candidates[i] + currentSum);
         }
      }

      private List<Integer> append(List<Integer> solution, int val){
         List<Integer> newSolution = new ArrayList<Integer>(solution);
         newSolution.add(val);
         return newSolution;
      }


   }
}
