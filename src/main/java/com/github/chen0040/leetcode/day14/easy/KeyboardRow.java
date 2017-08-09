package com.github.chen0040.leetcode.day14.easy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * link: https://leetcode.com/problems/keyboard-row/description/
 */
public class KeyboardRow {
   public class Solution {
      public String[] findWords(String[] words) {
         String[] keys = new String[] {
                 "qwertyuiop",
                 "ASDFGHJKLasdfghjkl",
                 "zxcvbnm"
         };
         List<String> result = new ArrayList<String>();
         for(int i=0; i < words.length; ++i) {
            String word = words[i];
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0; j < word.length(); ++j) {
               char c = word.charAt(j);
               for(int k=0; k < keys.length; ++k) {
                  if(keys[k].indexOf(c) != -1) {
                     set.add(k);
                     break;
                  }
               }
            }
            if(set.size() == 1) result.add(word);
         }
         String[] res = new String[result.size()];
         int index = 0;
         for(String w : result) {
            res[index++] = w;
         }
         return res;
      }
   }
}
