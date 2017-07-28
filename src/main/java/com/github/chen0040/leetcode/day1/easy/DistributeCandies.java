package com.github.chen0040.leetcode.day1.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 27/7/2017.
 *
 *
 * summary:
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 *
 * link: https://leetcode.com/problems/distribute-candies/tabs/description
 */
public class DistributeCandies {
   public class Solution {
      public int distributeCandies(int[] candies) {
         Set<Integer> unique = new HashSet<Integer>();
         for (int i = 0; i < candies.length; ++i) {
            unique.add(candies[i]);
         }
         return Math.min(candies.length / 2, unique.size());

      }
   }
}
