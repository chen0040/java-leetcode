package com.github.chen0040.leetcode.day14.medium;


/**
 * Created by xschen on 9/8/2017.
 */
public class CompareVersionNumbers {
   public class Solution {
      public int compareVersion(String version1, String version2) {
         String[] version1_parts = version1.split("\\.");
         String[] version2_parts = version2.split("\\.");

         int part_count = Math.max(version1_parts.length, version2_parts.length);

         int[] version1_comps = new int[part_count];
         int[] version2_comps = new int[part_count];

         for(int i=0; i < part_count; ++i) {
            int version1_part = version1_parts.length - 1 >= i ? Integer.parseInt(version1_parts[i]) : 0;
            int version2_part = version2_parts.length - 1 >= i ? Integer.parseInt(version2_parts[i]) : 0;
            if(version1_part != version2_part) {
               return Integer.compare(version1_part, version2_part);
            }
         }

         return 0;
      }
   }
}
