package com.github.chen0040.leetcode.day10.easy;


/**
 * Created by xschen on 5/8/2017.
 * summary:
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * link: https://leetcode.com/problems/can-place-flowers/description/
 */
public class CanPlaceFlowers {
   public class Solution {
      public boolean canPlaceFlowers(int[] flowerbed, int n) {

         int rem = n;
         for(int i=0; i < flowerbed.length;) {
            if(flowerbed[i] == 0) {
               if(i == 0){
                  if(i+1 >= flowerbed.length) {
                     flowerbed[i] = 1;
                     rem--;
                     i++;
                  } else {
                     if(flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        rem--;
                        i+=2;
                     } else i++;
                  }
               } else if(i == flowerbed.length-1) {
                  if(flowerbed[i-1] == 0) {
                     flowerbed[i] = 1;
                     rem--;
                  }
                  i++;
               } else {
                  if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                     flowerbed[i] = 1;
                     rem--;
                     i+=2;
                  } else i++;
               }
               if(rem <= 0) break;
            } else {
               i++;
            }

         }
         return rem <= 0;
      }
   }
}
