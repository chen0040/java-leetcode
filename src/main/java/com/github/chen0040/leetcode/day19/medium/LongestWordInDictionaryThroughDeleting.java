package com.github.chen0040.leetcode.day19.medium;


import java.util.Collections;
import java.util.List;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class LongestWordInDictionaryThroughDeleting {
   public class Solution {
      public String findLongestWord(String s, List<String> d) {
         Collections.sort(d);
         int maxLength = 0;
         String result = "";
         for(String w : d){
            int k = 0;
            boolean matched = true;
            for(int i=0; i < w.length(); ++i) {
               int c = w.charAt(i);
               boolean found = false;
               while(k < s.length()) {
                  if(s.charAt(k) == c) {
                     found = true;
                     break;
                  }
                  k++;
               }
               if(found) k++;
               else {
                  matched = false;
                  break;
               }
            }
            if(matched) {
               if(maxLength < w.length()) {
                  maxLength = w.length();
                  result = w;
               }
            }
         }
         return result;
      }
   }
}
