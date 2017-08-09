package com.github.chen0040.leetcode.day14.easy;


import java.util.Arrays;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * 
 * link: https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {
   public class Solution {
      public int findContentChildren(int[] g, int[] s) {
         Arrays.sort(g);
         Arrays.sort(s);
         int j = g.length-1;
         int points = 0;
         for(int i = s.length-1; i >= 0; --i) {
            int s_content = s[i];

            for(int k = j; k >= 0; --k) {
               if(g[k] <= s_content) {
                  points++;
                  j = k - 1;
                  break;
               }
            }

            if(j < 0) break;

         }

         return points;
      }
   }
}
