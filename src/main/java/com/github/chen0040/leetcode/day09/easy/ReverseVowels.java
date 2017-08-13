package com.github.chen0040.leetcode.day09.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * link: https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
public class ReverseVowels {
   public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.reverseVowels("hello"));
      System.out.println(s.reverseVowels("leetcode"));
   }
   public static class Solution {
      public String reverseVowels(String s) {
         if(s.length() == 0) return s;
         char[] a = s.toCharArray();
         int i = -1;
         int j = a.length;
         while(true) {
            while(!isVowel(a[++i])) {
               if(i >= a.length-1) break;
            }
            while(!isVowel(a[--j])) {
               if(j <= 0) break;
            }


            if(i >= j) break;

            exchange(a, i, j);
         }

         return new String(a);
      }

      private void exchange(char[] a, int i, int j) {
         char temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }

      private boolean isVowel(char c) {
         return "AEIOUaeiou".indexOf(c) != -1;
      }
   }
}
