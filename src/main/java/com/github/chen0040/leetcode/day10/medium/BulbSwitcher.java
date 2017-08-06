package com.github.chen0040.leetcode.day10.medium;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 * link: https://leetcode.com/problems/bulb-switcher/description/
 */
public class BulbSwitcher {
   public class Solution {
      public int bulbSwitch(int n) {
         return (int)Math.sqrt(n);
      }
   }
}
