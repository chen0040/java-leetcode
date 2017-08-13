package com.github.chen0040.leetcode.day02.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].
 * Sets S[K] for 0 <= K < N are defined as follows:
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
 * Sets S[K] are finite for each K and should NOT contain duplicates.
 * Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.
 *
 * link: https://leetcode.com/problems/array-nesting/tabs/description
 */
public class ArrayNesting {
   public class Solution {
      private boolean[] onStack;
      private Map<Integer, Integer> counts = new HashMap<Integer,Integer>();
      public int arrayNesting(int[] nums) {
         int N = nums.length;
         int maxCount = 0;
         onStack = new boolean[N];

         for(int i=0; i < N; ++i){
            if(counts.containsKey(nums[i])){
               continue;
            }
            int count = dfs(nums, nums[i]);
            maxCount = Math.max(count, maxCount);

         }
         return maxCount;
      }

      private int dfs(int[] nums, int x) {
         onStack[x] = true;

         int count = 1;
         x = nums[x];
         while(!onStack[x] && x != nums[x]) {
            onStack[x] = true;
            x = nums[x];

            if(counts.containsKey(x)) {
               count+=counts.get(x);
               break;
            } else {
               count++;
            }
         }

         onStack[x] = false;
         return count;
      }
   }
}
