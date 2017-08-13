package com.github.chen0040.leetcode.day06.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 *
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * link: https://leetcode.com/problems/implement-strstr/description/
 */
public class StrStr {
   public class Solution {
      public int strStr(String haystack, String needle) {
         for(int i=0; i <= haystack.length()-needle.length(); ++i) {
            boolean found = true;
            for(int j=0; j < needle.length(); ++j) {
               if(haystack.charAt(i+j) != needle.charAt(j)) {
                  found = false;
                  break;
               }
            }
            if(found){
               return i;
            }
         }
         return -1;
      }
   }
}
