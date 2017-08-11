package com.github.chen0040.leetcode.day16.medium;


import java.util.Arrays;
import java.util.List;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/minimum-time-difference/description/
 */
public class MinimumTimeDifference {
   public class Solution {
      public int findMinDifference(List<String> timePoints) {
         int[] res = new int[timePoints.size()];
         int index = 0;
         for(String t : timePoints) {
            String[] parts = t.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int total = hours * 60 + minutes;
            res[index++] = total;
         }
         Arrays.sort(res);
         int min = Integer.MAX_VALUE;
         for(int i=1; i < res.length; ++i) {
            min = Math.min(min, res[i] - res[i-1]);
         }
         min = Math.min(min, res[0] + 24 * 60 - res[res.length-1]);

         return min;
      }
   }
}
