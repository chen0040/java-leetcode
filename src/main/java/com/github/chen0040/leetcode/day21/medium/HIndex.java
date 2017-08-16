package com.github.chen0040.leetcode.day21.medium;


import java.util.Arrays;


/**
 * Created by xschen on 16/8/2017.
 *
 * link: https://leetcode.com/problems/h-index/description/
 */
public class HIndex {
   public class Solution {

      public int hIndex(int[] citations) {
         Arrays.sort(citations);
         int lo = 0;
         int hi = citations.length - 1;
         while(lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            int h = citations.length - mid;
            if(citations[mid] < h){
               lo = mid + 1;
            } else if(citations[mid] >= h) {
               hi = mid - 1;
            }
         }
         return citations.length - lo;
      }
   }
}
