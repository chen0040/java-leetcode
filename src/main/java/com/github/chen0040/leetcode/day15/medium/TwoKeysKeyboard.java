package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class TwoKeysKeyboard {
   public class Solution {
      public int minSteps(int n) {
         int[] steps = new int[n+1];
         for(int i = 2; i <= n; ++i) {
            steps[i] = i;
            for(int j = i - 1; j >= 2; --j) {
               if(i % j == 0) {
                  steps[i] = steps[j] + (i / j);
                  break;
               }
            }
         }
         return steps[n];
      }
   }
}
