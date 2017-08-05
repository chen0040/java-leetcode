package com.github.chen0040.leetcode.day8.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * link: https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 */
public class ConvertToHexadecimal {
   public class Solution {
      public String toHex(int num) {
         if(num == 0) return "0";
         if(num == Integer.MIN_VALUE) return "80000000";
         boolean neg = false;
         if(num < 0) {
            neg = true;
            num += Integer.MAX_VALUE;
         }
         String s = "";
         while(num > 0) {
            int d = (num % 16);
            if(neg && s.equals("")) {
               d++;
               if(d == 16) {
                  num++;
                  d = 0;
               }
            }
            char c = (char)((int)'0' + d);
            num /= 16;
            if(d > 9) {
               c = (char)((int)'a' + (d - 10));
            }
            if(neg && num == 0) {
               c = 'f';
            }
            s = c + s;
         }
         return s;
      }


   }
}
