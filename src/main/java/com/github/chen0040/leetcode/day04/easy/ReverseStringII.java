package com.github.chen0040.leetcode.day04.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 * link: https://leetcode.com/problems/reverse-string-ii/description/
 */
public class ReverseStringII {
   public class Solution {
      public String reverseStr(String s, int k) {
         for(int i=0; i < s.length(); i+=k) {
            if(i % (2 * k) == 0) {
               s = reverse(s, i, Math.min(s.length(), i+k));
            }
         }
         return s;
      }

      private String reverse(String s, int i, int j) {
         StringBuilder sb = new StringBuilder();
         for(int k=0; k < s.length(); ++k){
            if(k < i || k >= j) {
               sb.append(s.charAt(k));
            } else {
               sb.append(s.charAt(j - k + i - 1));
            }
         }
         return sb.toString();

      }
   }
}
