package com.github.chen0040.leetcode.day3.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 *
 * link: https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {

   public class Solution {
      public boolean isAnagram(String s, String t) {
         if(s.length() != t.length()) return false;
         Map<Character, Integer> counts_s = new HashMap<Character, Integer>();
         Map<Character, Integer> counts_t = new HashMap<Character, Integer>();

         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            counts_s.put(c, counts_s.getOrDefault(c, 0) + 1);
         }
         for(int i=0; i < t.length(); ++i) {
            char c = t.charAt(i);
            counts_t.put(c, counts_t.getOrDefault(c, 0) + 1);
         }
         for(Character c : counts_s.keySet()) {
            if(!counts_t.containsKey(c)) {
               return false;
            }
            if(counts_s.get(c).intValue() != counts_t.get(c).intValue()) {
               return false;
            }
         }
         return true;
      }
   }
}
