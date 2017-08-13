package com.github.chen0040.leetcode.day05.medium;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
   public class Solution {
      public int lengthOfLongestSubstring(String s) {
         if(s.equals("")) return 0;
         int maxLen = 0;
         for(int i=0; i < s.length(); ++i) {
            Set<Character> set = new HashSet<Character>();
            int len = 0;
            for(int j=i; j < s.length(); ++j) {
               char c = s.charAt(j);
               if(set.contains(c)) {
                  break;
               } else {
                  len++;
               }
               set.add(c);
            }
            maxLen = Math.max(maxLen, len);
         }
         return maxLen;
      }
   }
}
