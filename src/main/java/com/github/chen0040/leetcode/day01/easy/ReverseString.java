package com.github.chen0040.leetcode.day01.easy;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * Write a function that takes a string as input and returns the string reversed.
 *
 *
 * link: https://leetcode.com/problems/reverse-string/tabs/description
 */
public class ReverseString {
   public class Solution {
      public String reverseString(String s) {
         StringBuilder sb = new StringBuilder();
         for (int i = s.length() - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
         }
         return sb.toString();
      }
   }
}
