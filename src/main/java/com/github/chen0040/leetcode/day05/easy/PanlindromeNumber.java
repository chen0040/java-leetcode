package com.github.chen0040.leetcode.day05.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * link: https://leetcode.com/problems/palindrome-number/description/
 */
public class PanlindromeNumber {
   public class Solution {
      private int reverseInt(int x) {
         int result = 0;
         while(x > 0) {
            int digit = x % 10;
            result += digit;
            x /= 10;
            if(x > 0) {
               result = result * 10;
            }
         }
         return result;
      }
      public boolean isPalindrome(int x) {
         int x2 = reverseInt(x);
         return x2 == x;
      }
   }
}
