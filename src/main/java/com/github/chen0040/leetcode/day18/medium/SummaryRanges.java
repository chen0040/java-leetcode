package com.github.chen0040.leetcode.day18.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/summary-ranges/description/
 */
public class SummaryRanges {

   static class Range {
      int lo;
      int hi;
      public Range(int val) {
         lo = val;
         hi = val;
      }
      public String toString() {
         if(lo == hi) {
            return "" + lo;
         } else {
            return lo + "->" + hi;
         }
      }
   }

   public class Solution {

      public List<String> summaryRanges(int[] nums) {
         List<Range> ranges = new ArrayList<Range>();
         for(int i = 0; i < nums.length; ++i) {
            if(ranges.isEmpty()) {
               ranges.add(new Range(nums[i]));
            } else if(ranges.get(ranges.size()-1).hi + 1 == nums[i]) {
               ranges.get(ranges.size()-1).hi++;
            } else {
               ranges.add(new Range(nums[i]));
            }
         }
         List<String> result = new ArrayList<String>();
         for(Range range : ranges) {
            result.add(range.toString());
         }
         return result;

      }
   }
}
