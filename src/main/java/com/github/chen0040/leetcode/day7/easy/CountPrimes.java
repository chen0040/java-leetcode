package com.github.chen0040.leetcode.day7.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * link: https://leetcode.com/problems/count-primes/description/
 */
public class CountPrimes {
   public class Solution {
      public int countPrimes(int n) {
         boolean[] not_primes = new boolean[n];
         int count = 0;
         for(int i=2; i < n; ++i) {
            if(not_primes[i] == false) {
               count++;
               for(int j = 2; j * i < n; ++j){
                  not_primes[i * j] = true;
               }
            }
         }
         return count;
      }
   }
}
