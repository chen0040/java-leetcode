package com.github.chen0040.leetcode.day7.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * link: https://leetcode.com/problems/add-digits/description/
 */
public class AddDigits {
   public class Solution {
      public int addDigits(int num) {

         while(num >= 10) {
            num =sum(num);
         }
         return num;
      }

      private int sum(int num) {
         int sum = 0;
         while(num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
         }
         return sum;
      }
   }
}
