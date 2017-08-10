package com.github.chen0040.leetcode.day15.medium;


import java.util.List;
import java.util.Stack;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/exclusive-time-of-functions/description/
 */
public class ExclusiveTimeOfFunctions {
   public class Solution {


      public int[] exclusiveTime(int n, List<String> logs) {
         int[] result = new int[n];
         Stack<Integer> stack = new Stack<Integer>();
         int prev = 0;
         for(int i=0; i < logs.size(); ++i) {
            String log = logs.get(i);
            String[] parts = log.split(":");
            int fid = Integer.parseInt(parts[0]);
            boolean start = parts[1].equals("start");
            int time = Integer.parseInt(parts[2]);

            if(start) {
               if(!stack.isEmpty()) {
                  result[stack.peek()] += time - prev;
               }
               stack.push(fid);
               prev = time;
            } else {
               result[stack.pop()] += time - prev + 1;
               prev = time + 1;
            }

         }
         return result;

      }
   }
}
