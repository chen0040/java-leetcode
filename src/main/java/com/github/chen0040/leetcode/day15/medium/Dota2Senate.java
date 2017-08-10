package com.github.chen0040.leetcode.day15.medium;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/dota2-senate/description/
 */
public class Dota2Senate {
   public class Solution {
      public String predictPartyVictory(String senate) {
         char[] senate_members = senate.toCharArray();
         boolean[] marked = new boolean[senate_members.length];
         int num_r = 0;
         int num_d = 0;
         for(int i=0; i < senate_members.length; ++i) {
            if(senate_members[i] == 'R') num_r++;
            else num_d++;
         }
         return predict(senate_members, marked, num_r, num_d);
      }

      public String predict(char[] senate, boolean[] marked, int num_r, int num_d) {


         for(int i=0; i < senate.length; ++i) {
            if(marked[i]) continue;

            char c = senate[i];
            if(c == 'R') {
               if(num_d == 0) return "Radiant";
               else {
                  for(int j = 0; j < senate.length - 1 ; ++j) {
                     int d = (j + i + 1) % senate.length;
                     char c2 = senate[d];
                     if(c2 == 'D' && !marked[d]) {
                        marked[d] = true;
                        num_d--;
                        break;
                     }
                  }
               }
            } else {
               if(num_r == 0) return "Dire";
               else {
                  for(int j = 0; j < senate.length - 1 ; ++j) {
                     int d = (j + i + 1) % senate.length;
                     char c2 = senate[d];
                     if(c2 == 'R' && !marked[d]) {
                        marked[d] = true;
                        num_r--;
                        break;
                     }
                  }
               }
            }
         }

         return predict(senate, marked, num_r, num_d);
      }
   }
}
