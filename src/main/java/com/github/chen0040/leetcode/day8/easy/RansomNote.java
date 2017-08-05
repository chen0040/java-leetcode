package com.github.chen0040.leetcode.day8.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * link: https://leetcode.com/problems/ransom-note/description/
 */
public class RansomNote {
   public class Solution {
      public boolean canConstruct(String ransomNote, String magazine) {
         Map<Character, Integer> chars = new HashMap<Character, Integer>();
         for(int i=0; i < ransomNote.length(); ++i) {
            char c = ransomNote.charAt(i);
            chars.put(c, chars.getOrDefault(c, 0) + 1);
         }
         for(int i=0; i < magazine.length(); ++i) {
            char c = magazine.charAt(i);
            if(chars.containsKey(c)) {
               int count = chars.get(c);
               if(count > 1){
                  chars.put(c, count - 1);
               } else {
                  chars.remove(c);
               }
            }
         }
         return chars.isEmpty();
      }
   }
}
