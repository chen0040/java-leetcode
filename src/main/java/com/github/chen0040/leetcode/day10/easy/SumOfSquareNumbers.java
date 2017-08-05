package com.github.chen0040.leetcode.day10.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * link: https://leetcode.com/problems/sum-of-square-numbers/description/
 */
public class SumOfSquareNumbers {
   public class Solution {
      public boolean judgeSquareSum(int c) {
         int n = (int)Math.sqrt(c);
         Set<Integer> set = new HashSet<Integer>();
         for(int i=0; i <= n; ++i) {
            int k = i * i;
            if(k + k == c) return true;
            if(set.contains(k)) return true;
            int j = c - k;
            set.add(j);
         }
         return false;
      }
   }
}
