package com.github.chen0040.leetcode.day8.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * link: https://leetcode.com/problems/nth-digit/description/
 */
public class NthDigit {
   public class Solution {
      public int findNthDigit(int n) {
         int index = 1;
         long tens = 1;
         long lo = 0;
         long hi = 9;
         long number = 0;
         // 9 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6 +
         while(number + 9 * (tens * 10) < Long.MAX_VALUE) {

            if(n > lo && n <= hi) {
               int n1 = (int)(n - lo);
               int n2 = (int)(Math.ceil((double)n1 / index));
               int n3 = n1 % index;
               n3--;
               if(n3 < 0) n3 += index;

               long number2 = number + n2;
               return nthDigit(number2, n3);
            }

            number += 9 * tens;
            lo = hi;
            tens *= 10;
            index++;
            hi += 9 * tens * index;

         }
         return -1;
      }

      private int nthDigit(long num, int index) {

         return (int)("" + num).charAt(index) - (int)'0';
      }
   }
}
