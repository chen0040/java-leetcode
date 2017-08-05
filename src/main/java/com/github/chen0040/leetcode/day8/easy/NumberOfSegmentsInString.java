package com.github.chen0040.leetcode.day8.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 *
 * link: https://leetcode.com/problems/number-of-segments-in-a-string/description/
 */
public class NumberOfSegmentsInString {
   public class Solution {
      public int countSegments(String s) {
         s = s.trim();
         if(s.length() == 0) return 0;
         return s.split("\\s+").length;
      }
   }
}
