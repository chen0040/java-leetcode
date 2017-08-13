package com.github.chen0040.leetcode.day03.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * link: https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class FindUniqueCharacterInString {
   public class Solution {
      public int firstUniqChar(String s) {
         Map<Character, Integer> counts = new HashMap<Character, Integer>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
         }
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(counts.get(c) == 1) {
               return i;
            }
         }
         return -1;
      }
   }
}
