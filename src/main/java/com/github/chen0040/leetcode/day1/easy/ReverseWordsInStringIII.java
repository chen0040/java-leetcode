package com.github.chen0040.leetcode.day1.easy;


/**
 * Created by xschen on 27/7/2017.
 *
 *
 * link: https://leetcode.com/problems/reverse-words-in-string-iii/description/
 */
public class ReverseWordsInStringIII
{
   public class Solution {
      public String reverseWord(String word) {
         StringBuilder sb = new StringBuilder();
         for (int i = word.length() - 1; i >= 0; --i) {
            sb.append(word.charAt(i));
         }
         return sb.toString();
      }


      public String reverseWords(String s) {
         String[] words = s.split(" ");
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            word = reverseWord(word);
            if (i != 0) {
               sb.append(" ");
            }
            sb.append(word);
         }
         return sb.toString();
      }
   }
}
