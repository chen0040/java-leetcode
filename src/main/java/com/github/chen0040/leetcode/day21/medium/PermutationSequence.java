package com.github.chen0040.leetcode.day21.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 16/8/2017.
 *
 * link: https://leetcode.com/problems/permutation-sequence/description/
 */
public class PermutationSequence {
   public class Solution {
      String target;
      int count;
      public String getPermutation(int n, int k) {
         int[] factorial = new int[n];
         factorial[0] = 1;
         for(int i = 1; i < n; ++i) {
            factorial[i] = factorial[i-1] * i;
         }

         k--;

         List<Integer> nums = new ArrayList<Integer>();
         for(int i=0; i < n; ++i) {
            nums.add(i+1);
         }
         StringBuilder sb = new StringBuilder();
         for(int i=1; i <= n; ++i) {
            int index = k / factorial[n-i];
            sb.append(nums.get(index));
            nums.remove(nums.get(index));
            k -= index * factorial[n-i];
         }

         return sb.toString();
      }



   }
}
