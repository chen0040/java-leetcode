package com.github.chen0040.leetcode.day1.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * link: https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
   public class Solution {

      private Map<Integer, Integer> counts;
      public List<Integer> topKFrequent(int[] nums, int k) {
         counts = new HashMap<Integer, Integer>();
         for(int i=0; i < nums.length; ++i) {
            int num = nums[i];
            counts.put(num, counts.getOrDefault(num, 0) + 1);
         }
         int[] a = new int[counts.size()];
         int index = 0;
         for(Integer val : counts.keySet()) {
            a[index++] = val;
         }
         quickSort(a, 0, a.length-1);
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < k; ++i){
            result.add(a[i]);
         }
         return result;
      }

      private void quickSort(int[] a, int lo, int hi) {
         if(lo >= hi) return;
         int j = partition(a, lo, hi);
         quickSort(a, lo, j-1);
         quickSort(a, j+1, hi);
      }

      private int partition(int[] a, int lo, int hi) {
         int i=lo, j= hi+1;
         int v = counts.get(a[lo]);
         while(true) {
            while(v < counts.get(a[++i])) {
               if(i >= hi) break;
            }
            while(v > counts.get(a[--j])) {
               if(j <= lo) break;
            }
            if(i >= j) {
               break;
            }
            exchange(a, i, j);
         }
         exchange(a, lo, j);
         return j;
      }

      private void exchange(int[] a, int i, int j){
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }
   }
}
