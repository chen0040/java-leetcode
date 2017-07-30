package com.github.chen0040.leetcode.day4.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * link: https://leetcode.com/problems/number-of-boomerangs/description/
 */
public class NumberOfBoomerangs {
   public class Solution {
      public int numberOfBoomerangs(int[][] points) {
         int result = 0;
         for(int i=0; i < points.length; ++i) {
            Map<Integer, Integer> distances = new HashMap<Integer, Integer>();
            for(int j=0; j < points.length; ++j) {
               if(i == j ) continue;
               int distance = getDistance(points[i], points[j]);
               distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry : distances.entrySet()) {
               int distance = entry.getKey();
               int count = entry.getValue();
               if(count < 2) continue;
               result += getCount(count, 2);
            }
         }
         return result;
      }

      private int getCount(int m, int n) {
         return factorial(m) / factorial(m-n);
      }

      private int factorial(int n) {
         if(n <= 1) return 1;
         return n * factorial(n-1);
      }

      private int getDistance(int[] pt1, int[] pt2) {
         int x = pt1[0] - pt2[0];
         int y = pt1[1] - pt2[1];
         return x * x + y * y;
      }
   }
}
