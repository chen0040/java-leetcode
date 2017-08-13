package com.github.chen0040.leetcode.day09.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given two arrays, write a function to compute their intersection.
 *
 * link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
public class IntersectionOfTwoArraysII {
   public class Solution {
      public int[] intersect(int[] nums1, int[] nums2) {
         Map<Integer, Integer> set = new HashMap<Integer, Integer>();
         for(int i=0; i < nums1.length; ++i) {
            set.put(nums1[i], set.getOrDefault(nums1[i], 0)+1);
         }
         Map<Integer, Integer> set2 = new HashMap<Integer, Integer>();
         for(int i=0; i < nums2.length; ++i) {
            if(set.containsKey(nums2[i])){
               set2.put(nums2[i], Math.min(set.get(nums2[i]), set2.getOrDefault(nums2[i], 0)+1));
            }
         }
         int index = 0;
         List<Integer> list = new ArrayList<Integer>();
         for(Map.Entry<Integer, Integer> entry : set2.entrySet()) {
            int i = entry.getKey();
            for(int k=0; k < entry.getValue(); ++k){
               list.add(i);
            }
         }

         int[] result = new int[list.size()];
         for(Integer i : list) {
            result[index++] = i;
         }
         return result;
      }
   }
}
