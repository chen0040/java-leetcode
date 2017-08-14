package com.github.chen0040.leetcode.day19.easy;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/largest-palindrome-product/description/
 */
public class LargestPanlinedromeProduct {
   public class Solution {
      public int largestPalindrome(int n) {

         if(n == 1) return 9;

         int upperBound = (int)Math.pow(10, n) - 1;
         int lowerBound = (int)Math.pow(10, n-1);

         long maxNumber = (long)upperBound * (long)upperBound;

         int firstHalf = (int)(maxNumber / (long)Math.pow(10, n));
         while(true) {
            long candidate = createPanlindrome(firstHalf);
            for(long i = upperBound; i >= lowerBound; --i) {
               if (i * i < candidate) {
                  break;
               }

               if(candidate % i == 0) {
                  return (int)(candidate % 1337);
               }
            }
            firstHalf--;
            if(firstHalf < 0) break;
         }
         return -1;
      }

      long createPanlindrome(int firstHalf) {
         StringBuilder sb = new StringBuilder();
         sb.append(firstHalf);
         sb.reverse();
         String str = firstHalf + sb.toString();
         return Long.parseLong(str);

      }
   }
}
