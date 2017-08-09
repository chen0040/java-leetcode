package com.github.chen0040.leetcode.day14.easy;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
 * 
 * link: https://leetcode.com/problems/poor-pigs/description/
 */
public class PoorPigs {
   public class Solution {
      public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
         double times = minutesToTest / minutesToDie + 1;
         double pigs = Math.log(buckets) / Math.log(times);
         return (int)(Math.ceil(pigs));
      }
   }
}
