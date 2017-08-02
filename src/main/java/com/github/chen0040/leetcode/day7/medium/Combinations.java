package com.github.chen0040.leetcode.day7.medium;


import java.util.*;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * link: https://leetcode.com/problems/combinations/description/
 */
public class Combinations {
   public class Solution {
      public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> sets =new ArrayList<List<Integer>>();
         if(k==0) return sets;
         if(n == k) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i < n; ++i) {
               list.add(i+1);
            }
            return Arrays.asList(list);
         }
         for(int i=0; i < n; ++i) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i+1);
            sets.add(list);
         }
         if(k < n / 2) {
            collect(n, k, sets, 1);
         } else {
            collect(n, n - k, sets, 1);
            List<List<Integer>> complements = new ArrayList<List<Integer>>();
            for(int i=0; i < sets.size(); ++i){
               complements.add(complement(sets.get(i), n));
            }
            sets = complements;
         }

         return sets;
      }

      private List<Integer> complement(List<Integer> list, int n) {
         Set<Integer> set = new HashSet<Integer>(list);
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < n; ++i) {
            if(set.contains(i+1)) continue;
            result.add(i+1);
         }
         return result;
      }

      private void collect(int n, int k, List<List<Integer>> sets, int d) {
         if(d == k) {
            return;
         }

         List<List<Integer>> newSets = new ArrayList<List<Integer>>();
         for(List<Integer> set : sets){
            List<List<Integer>> newSubSets = generate(set, set.get(set.size()-1), n);
            newSets.addAll(newSubSets);
         }

         sets.clear();
         sets.addAll(newSets);
         collect(n, k, sets, d+1);
      }

      private List<List<Integer>> generate(List<Integer> seq, int val, int n) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         for(int i=val+1; i <= n; ++i) {
            List<Integer> l =new ArrayList<Integer>(seq);
            l.add(i);
            result.add(l);
         }
         return result;
      }

   }
}
