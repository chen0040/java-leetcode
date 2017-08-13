package com.github.chen0040.leetcode.day06.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 *
 * link: https://leetcode.com/problems/count-and-say/description/
 */
public class CountAndSay {
   public class Solution {
      private int zero;
      public String countAndSay(int n) {
         zero = (int)'0';
         return countAndSay("1", 1, n);
      }
      public String countAndSay(String seq, int d, int n) {
         if(d == n) {
            return seq;
         }
         int count = 0;
         int prev_digit = -1;
         int digit = 0;
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < seq.length(); ++i) {
            digit = (int)seq.charAt(i) - zero;
            if(i != 0 && digit != prev_digit) {
               sb.append(count);
               sb.append(prev_digit);
               count = 0;
            }
            prev_digit = digit;
            count++;
         }
         sb.append(count);
         sb.append(digit);
         return countAndSay(sb.toString(), d+1, n);
      }
   }
}
