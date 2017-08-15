package com.github.chen0040.leetcode.day20.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 15/8/2017.
 *
 * link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class LongestSubstringWithAtLeastKRepeatedCharacters {
   public class Solution {
      public int longestSubstring(String s, int k) {
         Map<Character, Integer> counts = new HashMap<Character, Integer>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
         }
         StringBuilder sb = new StringBuilder();
         for(Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if(entry.getValue().intValue() < k) {
               sb.append(entry.getKey());
            }
         }
         String lowFreqWords = sb.toString();
         //System.out.println(lowFreqWords);

         List<int[]> ranges = new ArrayList<int[]>();
         int lo = 0;
         int hi = 0;
         if(!lowFreqWords.isEmpty()) {
            for(int i=0; i < s.length(); ++i) {
               char c = s.charAt(i);
               if(lowFreqWords.indexOf(c) != -1) {
                  hi = i - 1;
                  if(hi >= lo) {
                     ranges.add(new int[] { lo, hi});
                     hi = -1;
                  }
                  lo = i + 1;
               } else {
                  hi++;
               }
            }
            if(hi != -1) {
               if(s.length()-1 >= lo){
                  ranges.add(new int[] { lo, s.length() - 1});
               }
            }

            int maxLen = 0;
            for(int[] range : ranges){
               //System.out.println("[" + range[0] + ", " + range[1] + "]");
               String s2 = s.substring(range[0], range[1] + 1);
               if(s2.length() < k) continue;

               maxLen = Math.max(maxLen, longestSubstring(s2, k));
            }
            return maxLen;

         } else {
            return s.length();
         }
      }
   }
}
