package com.github.chen0040.leetcode.day16.medium;


import java.util.*;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/task-scheduler/description/
 */
public class TaskScheduler {
   public class Solution {
      public int leastInterval(char[] tasks, int n) {
         Map<Character, Integer> map = new HashMap<Character, Integer>();
         for(int i=0; i < tasks.length; ++i) {
            char t = tasks[i];
            map.put(t, map.getOrDefault(t, 0) + 1);
         }


         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
               if(a.getValue().equals(b.getValue())){
                  return Character.compare(a.getKey(), b.getKey());
               } else {
                  return Integer.compare(b.getValue(), a.getValue());
               }
            }
         });

         pq.addAll(map.entrySet());

         int count = 0;
         while(!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> temp = new ArrayList<Map.Entry<Character, Integer>>();
            while(k > 0 && !pq.isEmpty()) {
               Map.Entry<Character, Integer> entry = pq.poll();
               entry.setValue(entry.getValue() - 1);
               if(entry.getValue() > 0) {
                  temp.add(entry);
               }
               k--;
               count++;
            }

            pq.addAll(temp);

            if(pq.isEmpty()) {
               break;
            }

            count = count + k;
         }

         return count;

      }
   }
}
