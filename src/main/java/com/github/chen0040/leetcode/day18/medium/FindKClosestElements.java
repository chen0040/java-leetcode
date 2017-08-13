package com.github.chen0040.leetcode.day18.medium;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/contest/leetcode-weekly-contest-45/problems/find-k-closest-elements/
 */
public class FindKClosestElements {
   public class Solution {
      public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            int distance1 = Math.abs(b - x);
            int distance2 = Math.abs(a - x);
            if(distance1 == distance2) {
               return b - a;
            } else {
               return Integer.compare(distance1, distance2);
            }
         });
         for(int i=0; i < arr.size(); ++i) {
            int num = arr.get(i);
            pq.add(num);
            if(pq.size() > k) {
               pq.poll();
            }
         }

         List<Integer> res =new ArrayList<Integer>();
         while(!pq.isEmpty()) {
            res.add(pq.poll());
         }
         Collections.sort(res);
         return res;
      }
   }
}
