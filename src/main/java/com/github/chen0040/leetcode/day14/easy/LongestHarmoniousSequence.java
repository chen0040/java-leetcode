package com.github.chen0040.leetcode.day14.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://leetcode.com/problems/longest-harmonious-subsequence/description/
 */
public class LongestHarmoniousSequence {
   public class Solution {
      public int findLHS(int[] nums) {
         Map<Integer, int[]> map = new HashMap<Integer, int[]>();
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];

            int[] states = map.getOrDefault(num, new int[] {0, 0});
            states[0]++;
            map.put(num, states);

            states = map.getOrDefault(num+1, new int[] {0, 0});
            states[1]++;
            map.put(num+1, states);
         }

         int maxLength = 0;
         for(int[] len : map.values()) {
            if(len[0] == 0 || len[1] == 0) continue;
            maxLength = Math.max(maxLength, len[0] + len[1]);
         }
         return maxLength;
      }
   }
}
