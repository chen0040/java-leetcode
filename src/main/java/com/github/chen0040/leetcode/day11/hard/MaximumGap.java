package com.github.chen0040.leetcode.day11.hard;


import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Created by xschen on 6/8/2017.
 *
 * summary:
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * 
 * link: https://leetcode.com/problems/maximum-gap/description/
 */
public class MaximumGap {
   public class Solution {
      public int maximumGap(int[] nums) {
         if(nums.length < 2) return 0;
         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
               return a - b;
            }
         });
         for(int i=0; i < nums.length; ++i) {
            pq.add(nums[i]);
         }
         int prev = pq.remove();
         int result = 0;
         while(!pq.isEmpty()) {
            int num = pq.remove();
            result = Math.max(result, num - prev);
            prev = num;
         }
         return result;
      }
   }
}
