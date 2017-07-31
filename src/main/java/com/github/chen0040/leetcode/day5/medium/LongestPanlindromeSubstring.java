package com.github.chen0040.leetcode.day5.medium;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * link: https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPanlindromeSubstring {
   public class Solution {
      public String longestPalindrome(String s) {
         if(s.length() <= 1) return s;
         if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0, 1);
         }

         String result = "";
         for(int i=0; i < s.length()-1; ++i) {
            String trial = attempt1(s, i);
            if(trial.length() > result.length()) {
               result = trial;
            }
            trial = attempt2(s, i);
            if(trial.length() > result.length()) {
               result = trial;
            }
         }
         return result;
      }
      private String attempt1(String s, int k) {
         int i=k-1, j=k+1;
         int ri = k, rj = k;
         while(i >= 0 && j < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
               ri = i;
               rj = j;
            } else {
               break;
            }
            i--;
            j++;
         }

         return s.substring(Math.max(0, ri), Math.min(rj+1, s.length()));
      }

      private String attempt2(String s, int k) {
         int i=k, j=k+1;
         int ri = k, rj = k;
         while(i >= 0 && j < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
               ri = i;
               rj = j;
            } else {
               break;
            }
            i--;
            j++;
         }

         return s.substring(Math.max(0, ri), Math.min(rj+1, s.length()));
      }
   }
}
