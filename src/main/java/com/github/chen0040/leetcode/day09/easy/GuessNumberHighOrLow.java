package com.github.chen0040.leetcode.day09.easy;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * link: https://leetcode.com/problems/guess-number-higher-or-lower/description/
 */
public class GuessNumberHighOrLow {
   public class GuessGame {
      int k = 6;
      int guess (int n) {
         if(n == k) return 0;
         if(n < k) return 1;
         return -1;
      }
   }
   public class Solution extends GuessGame {
      public int guessNumber(int n) {
         int lo = 1;
         int hi = n;
         while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int res = guess(mid);
            if(res == -1) {
               hi = mid - 1;
            } else if(res == 1) {
               lo = mid + 1;
            } else {
               return mid;
            }
         }
         return lo;
      }
   }
}
