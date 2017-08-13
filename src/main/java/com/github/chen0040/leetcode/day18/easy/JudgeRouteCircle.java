package com.github.chen0040.leetcode.day18.easy;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/contest/leetcode-weekly-contest-45/problems/judge-route-circle/
 */
public class JudgeRouteCircle {
   public class Solution {
      public boolean judgeCircle(String moves) {
         int row = 0;
         int col = 0;
         for(int i = 0; i < moves.length(); ++i) {
            char c = moves.charAt(i);
            if(c == 'U') row--;
            else if(c == 'D') row++;
            else if(c == 'L') col--;
            else col++;
         }
         return row == 0 && col == 0;
      }
   }
}
