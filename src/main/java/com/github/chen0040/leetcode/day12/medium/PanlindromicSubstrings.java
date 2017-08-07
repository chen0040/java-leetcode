package com.github.chen0040.leetcode.day12.medium;


/**
 * Created by xschen on 7/8/2017.
 *
 * summary:
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * link: https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PanlindromicSubstrings {
   public class Solution {
      public int countSubstrings(String s) {
         int count = 0;
         for(int i=0; i < s.length(); ++i) {
            for(int j=i; j < s.length(); ++j)    {
               String a = s.substring(i, j+1);
               if(isValid(a)) {
                  count++;

               }
            }
         }

         return count;
      }

      private boolean isValid(String a) {
         StringBuilder sb = new StringBuilder();
         sb.append(a);
         sb.reverse();
         return sb.toString().equals(a);
      }
   }
}
