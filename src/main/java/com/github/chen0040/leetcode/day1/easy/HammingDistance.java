package com.github.chen0040.leetcode.day1.easy;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 *
 * link: https://leetcode.com/problems/hamming-distance/tabs/description
 */
public class HammingDistance
{
   public class Solution {
      public int hammingDistance(int x, int y) {
         int xor = x ^ y;
         int distance = 0;
         while (xor > 0) {
            distance += (xor & 1) > 0 ? 1 : 0;
            xor >>= 1;
         }
         return distance;
      }
   }
}
