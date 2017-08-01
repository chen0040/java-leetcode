package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * link: https://leetcode.com/problems/plus-one/description/
 */
public class PlusOne {
   public class Solution {
      public int[] plusOne(int[] digits) {
         if(digits.length==0) {
            int[] result = new int[1];
            result[0] = 1;
            return result;
         }
         return plusOne(digits, 1, digits.length-1);
      }

      public int[] plusOne(int[] digits, int carry, int d) {
         if(d == 0){
            if(digits[d]+carry >= 10){
               int[] result = new int[digits.length+1];
               for(int i=0; i < digits.length; ++i) {
                  result[i+1] = digits[i];
               }
               result[1] = digits[0]+carry - 10;
               result[0] = 1;
               return result;
            } else {
               digits[d] += carry;
               return digits;
            }
         }

         if(digits[d] + carry >= 10){
            digits[d] = digits[d] + carry - 10;
            carry = 1;
         } else {
            digits[d] += carry;
            carry = 0;
         }
         return plusOne(digits, carry, d-1);
      }

   }
}
