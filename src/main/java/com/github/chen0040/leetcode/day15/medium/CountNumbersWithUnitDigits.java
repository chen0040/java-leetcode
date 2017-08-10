package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 */
public class CountNumbersWithUnitDigits {
   public class Solution {
      public int countNumbersWithUniqueDigits(int n) {
         if (n == 0) {
            return 1;
         }
         int ans = 10, base = 9;
         for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
         }
         return ans;
      }
   }
}
