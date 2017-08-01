package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given two binary strings, return their sum (also a binary string).
 * 
 * link: https://leetcode.com/problems/add-binary/description/
 */
public class AddBinary {
   public class Solution {

      private String pad(String a, int zeroes) {
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < zeroes; ++i){
            sb.append('0');
         }
         sb.append(a);
         return sb.toString();
      }

      public String xor(String a, String b){
         int len = Math.max(a.length(), b.length());
         if(a.length() < len) {
            a = pad(a, len - a.length());
         }
         if(b.length() < len) {
            b = pad(b, len - b.length());
         }
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < len; ++i) {
            if(a.charAt(i) == b.charAt(i)){
               sb.append('0');
            } else {
               sb.append('1');
            }
         }
         return sb.toString();
      }

      public String and(String a, String b){
         int len = Math.max(a.length(), b.length());
         if(a.length() < len) {
            a = pad(a, len - a.length());
         }
         if(b.length() < len) {
            b = pad(b, len - b.length());
         }
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < len; ++i) {
            if(a.charAt(i) == b.charAt(i) && a.charAt(i) == '1'){
               sb.append('1');
            } else {
               sb.append('0');
            }
         }
         return sb.toString();
      }

      public String shiftLeft(String a) {
         if(a.length() > 0){
            return a + "0";
         }
         return a;
      }

      public boolean isZero(String b) {
         for(int i=0; i < b.length(); ++i) {
            if(b.charAt(i) != '0'){
               return false;
            }
         }
         return true;
      }

      private String trim(String a) {
         if(a.length() > 1 && a.charAt(0) == '0'){
            return trim(a.substring(1, a.length()));
         }
         return a;
      }

      public String addBinary(String a, String b) {
         if(isZero(b)) {
            return trim(a);
         }
         String carry = shiftLeft(and(a, b));
         a = xor(a, b);
         return addBinary(a, carry);
      }
   }
}
