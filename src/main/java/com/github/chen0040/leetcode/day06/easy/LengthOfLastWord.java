package com.github.chen0040.leetcode.day06.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * link: https://leetcode.com/problems/length-of-last-word/description/
 */
public class LengthOfLastWord {
   public class Solution {
      public int lengthOfLastWord(String s) {
         int count = 0;
         int prevCount = 0;
         for(int i=0; i < s.length(); ++i) {
            if(s.charAt(i) == ' ') {
               if(count != 0) prevCount = count;
               count = 0;
            } else {
               count++;
            }
         }
         return count == 0 ? prevCount : count;
      }
   }
}
