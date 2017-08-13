package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {
   public class Solution {
      private int count;
      public int countArrangement(int N) {
         count = 0;
         boolean[] onStack = new boolean[N+1];
         dfs(N, 1, onStack);
         return count;
      }
      private void dfs(int N, int pos, boolean[] onStack) {
         if(pos > N) {
            count++;
            return;
         }

         for(int i = 1; i <= N; ++i) {

            if(!onStack[i] && (pos % i == 0 || i % pos == 0)) {
               onStack[i] = true;
               dfs(N, pos+1, onStack);
               onStack[i] = false;
            }
         }


      }
   }
}
