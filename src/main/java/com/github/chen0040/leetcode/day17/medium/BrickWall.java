package com.github.chen0040.leetcode.day17.medium;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/brick-wall/description/
 */
public class BrickWall {
   public class Solution {
      public int leastBricks(List<List<Integer>> wall) {
         Map<Integer, Integer> gapCounts = new HashMap<Integer, Integer>();

         int boundary = 0;
         for(int i=0; i < wall.size(); ++i) {
            int sum = 0;
            List<Integer> line = wall.get(i);
            for(int j=0; j < line.size(); ++j) {
               sum+=line.get(j);
               gapCounts.put(sum, gapCounts.getOrDefault(sum, 0) + 1);
            }
            boundary = Math.max(boundary, sum);
         }

         int maxIndex = -1;
         int maxCount = 0;
         for(Map.Entry<Integer, Integer> entry : gapCounts.entrySet()) {
            int index = entry.getKey();
            int count = entry.getValue();
            if(count > maxCount && index != boundary) {
               maxCount = count;
               maxIndex = index;
            }
         }
         if(maxIndex == -1) return wall.size();
         return wall.size() - maxCount;
      }
   }
}
