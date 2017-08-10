package com.github.chen0040.leetcode.day15.medium;


import java.util.List;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/replace-words/description/
 */
public class ReplaceWords {
   public class Solution {
      public String replaceWords(List<String> dict, String sentence) {
         String[] words = sentence.split(" ");
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< words.length; ++i) {

            String filtered = words[i];
            for(String root : dict) {
               if(filtered.startsWith(root)) {
                  filtered = root;
                  break;
               }
            }
            if(i != 0) {
               sb.append(" ");
            }
            sb.append(filtered);
         }
         return sb.toString();
      }
   }
}
