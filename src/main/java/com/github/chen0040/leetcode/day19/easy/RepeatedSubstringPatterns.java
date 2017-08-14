package com.github.chen0040.leetcode.day19.easy;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/repeated-substring-pattern/description/
 */
public class RepeatedSubstringPatterns {
   public class Solution {
      public boolean repeatedSubstringPattern(String s) {
         for(int i = s.length() / 2; i >= 1;--i) {
            if(s.length() % i == 0) {
               int count = s.length() / i;
               String comp = s.substring(0, i);
               StringBuilder sb = new StringBuilder();
               for(int j = 0; j < count; ++j) {
                  sb.append(comp);
               }
               if(sb.toString().equals(s)) return true;
            }
         }
         return false;
      }
   }
}
