package com.github.chen0040.leetcode.day12.easy;


/**
 * Created by xschen on 7/8/2017.
 *
 * link: https://leetcode.com/problems/construct-the-rectangle/description/
 */
public class ConstructRectangle {
   public class Solution {
      public int[] constructRectangle(int area) {
         int k = (int)Math.sqrt(area);
         int i;
         for(i = k; i >= 1; --i) {
            if(area % i == 0) {
               break;
            }
         }
         return new int[] { area / i, i };
      }
   }
}
