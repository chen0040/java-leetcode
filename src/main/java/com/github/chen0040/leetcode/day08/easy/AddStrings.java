package com.github.chen0040.leetcode.day08.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * link: https://leetcode.com/problems/add-strings/description/
 */
public class AddStrings {
   public class Solution {
      public String addStrings(String num1, String num2) {
         if(isZero(num2)) return trim(num1);
         String carry = computeCarry(num1, num2);
         num1 = computeRemainder(num1, num2);
         return addStrings(num1, carry);
      }

      private String trim(String num) {
         char[] chars = num.toCharArray();
         StringBuilder sb = new StringBuilder();
         boolean firstNonZeroChar = false;
         for(int i=0; i < chars.length; ++i) {
            if(chars[i] != '0') {
               firstNonZeroChar = true;
               sb.append(chars[i]);
            } else {
               if(firstNonZeroChar) {
                  sb.append(chars[i]);
               }
            }
         }
         String result = sb.toString();
         if(result.length() == 0) return "0";
         return result;
      }

      private boolean isZero(String num) {
         for(int i=0; i < num.length(); ++i) {
            if(num.charAt(i) != '0') {
               return false;
            }
         }
         return true;
      }

      private String computeCarry(String num1, String num2) {
         int len = Math.max(num1.length(), num2.length());
         int[] a = convert(num1, len);
         int[] b = convert(num2, len);
         int[] c = new int[len];
         for(int i=0; i < len; ++i) {
            int d = a[i] + b[i];
            d /= 10;
            c[len - i - 1] = d;
         }
         return toString(c)+ "0";
      }

      private String computeRemainder(String num1, String num2) {
         int len = Math.max(num1.length(), num2.length());
         int[] a = convert(num1, len);
         int[] b = convert(num2, len);
         int[] c = new int[len];
         for(int i=0; i < len; ++i) {
            int d = a[i] + b[i];
            d %= 10;
            c[len - i - 1] = d;
         }
         return toString(c);
      }

      private String toString(int[] c) {
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < c.length; ++i) {
            sb.append(c[i]);
         }
         return sb.toString();
      }

      private int[] convert(String num, int len) {
         int[] result = new int[len];

         for(int i=0; i < num.length(); ++i) {
            char c = num.charAt(i);
            int d = (int)c - (int)'0';
            result[num.length() - i - 1] = d;
         }
         return result;
      }
   }
}
