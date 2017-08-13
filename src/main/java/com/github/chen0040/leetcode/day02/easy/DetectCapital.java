package com.github.chen0040.leetcode.day02.easy;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * link: https://leetcode.com/problems/detect-capital/tabs/description
 */
public class DetectCapital {
   private static String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public class Solution {

      public boolean detectCapitalUse(String word) {
         int capitalCount = 0;

         boolean first = false;
         for(int i=0; i < word.length(); ++i) {
            if(all.indexOf(word.charAt(i)) != -1) {
               capitalCount++;
               if(i==0) {
                  first = true;
               }
            }
         }

         return capitalCount == word.length() || capitalCount == 0 || (first && capitalCount == 1);
      }
   }
}
