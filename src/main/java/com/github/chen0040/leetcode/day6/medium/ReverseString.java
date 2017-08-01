package com.github.chen0040.leetcode.day6.medium;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given an input string, reverse the string word by word.
 * 
 * link: https://leetcode.com/problems/reverse-words-in-a-string/description/
 */
public class ReverseString {

   public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.reverseWords("the sky is blue"));
      System.out.println(s.reverseWords(" 1"));
      System.out.println(s.reverseWords("1 "));
   }
   public static class Solution {
      public String reverseWords(String s) {
         if(s.length() == 0) return "";
         String[] a = s.split("\\s+");
         for(int i=0; i < a.length / 2; ++i) {
            exchange(a, i, a.length - i - 1);
         }
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < a.length; ++i) {
            if(i != 0) {
               sb.append(' ');
            }
            sb.append(a[i]);
         }

         return sb.toString().trim();
      }

      private void exchange(String[] a, int i, int j) {
         String temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }
   }
}
