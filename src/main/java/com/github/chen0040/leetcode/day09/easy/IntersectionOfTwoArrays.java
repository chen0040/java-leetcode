package com.github.chen0040.leetcode.day09.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given two arrays, write a function to compute their intersection.
 *
 * link: https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class IntersectionOfTwoArrays {
   public class Solution {
      public int[] intersection(int[] nums1, int[] nums2) {
         Set<Integer> set = new HashSet<Integer>();
         for(int i=0; i < nums1.length; ++i) {
            set.add(nums1[i]);
         }
         Set<Integer> set2 = new HashSet<Integer>();
         for(int i=0; i < nums2.length; ++i) {
            if(set.contains(nums2[i])){
               set2.add(nums2[i]);
            }
         }
         int index = 0;
         int[] result = new int[set2.size()];
         for(Integer i : set2) {
            result[index++] = i;
         }
         return result;
      }
   }
}
