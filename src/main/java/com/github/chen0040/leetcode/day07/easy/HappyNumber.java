package com.github.chen0040.leetcode.day07.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * link: https://leetcode.com/problems/happy-number/description/
 */
public class HappyNumber {
   public class Solution {

      public boolean isHappy(int n) {
         Set<Integer> history = new HashSet<Integer>();
         return isHappy(n, history);
      }

      private boolean isHappy(int n, Set<Integer> history) {
         if(n == 1) return true;
         if(history.contains(n)) {
            return false;
         }
         history.add(n);
         int next = 0;
         while(n > 0) {
            int x = n % 10;
            next += x * x;
            n /= 10;
         }
         return isHappy(next, history);
      }
   }
}
