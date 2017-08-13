package com.github.chen0040.leetcode.day07.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * link: https://leetcode.com/problems/multiply-strings/description/
 */
public class MultiplyStrings {
   public class Solution {
      public String multiply(String num1, String num2) {
         Map<Integer, Integer> sum = new HashMap<Integer, Integer>();
         int maxZeroes = 0;
         for(int i=0; i < num1.length(); ++i){
            int digit1 = (int)(num1.charAt(num1.length()-1-i)) - (int)'0';
            for(int j=0; j < num2.length(); ++j){
               int digit2 = (int)(num2.charAt(num2.length()-1-j)) - (int)'0';
               int zeroes = i + j;
               int p = digit1 * digit2;
               if(p % 10 == 0) {
                  zeroes++;
                  p /= 10;
               }
               maxZeroes = Math.max(zeroes, maxZeroes);
               sum.put(zeroes, sum.getOrDefault(zeroes, 0) + p);
            }
         }

         int carry = 0;
         String s = "";
         int index = 0;
         while(index <= maxZeroes || carry > 0) {
            int num = sum.getOrDefault(index, 0) + carry;
            int digit = num % 10;
            s = digit + s;
            carry = num / 10;
            index++;
         }

         if(carry > 0) {
            s = carry + s;
         }

         return trim(s);
      }

      private String trim(String s) {
         StringBuilder sb = new StringBuilder();
         boolean first = true;
         for(int i=0; i < s.length(); ++i) {
            if(s.charAt(i) == '0'){
               if(first == false) {
                  sb.append(s.charAt(i));
               }
            } else {
               sb.append(s.charAt(i));
               first = false;
            }
         }
         if(first) {
            sb.append("0");
         }
         return sb.toString();
      }

   }
}
