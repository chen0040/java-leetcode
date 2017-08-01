package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * link: https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPanlindrome {
   public class Solution {
      private String test = "abcdefghijklmnopqrstuvwxyz0123456789";
      public boolean isPalindrome(String s) {
         s = process(s);
         return s.equals(reverse(s));
      }

      private String reverse(String s) {
         return new StringBuilder(s).reverse().toString();
      }

      private boolean isAlphaNumeric(char c) {
         return test.indexOf(c) != -1;
      }
      private String process(String s) {
         s = s.toLowerCase();
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < s.length(); ++i) {
            if(isAlphaNumeric(s.charAt(i))) {
               sb.append(s.charAt(i));
            }
         }
         return sb.toString();
      }
   }
}
