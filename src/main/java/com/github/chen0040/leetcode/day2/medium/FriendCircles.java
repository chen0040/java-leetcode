package com.github.chen0040.leetcode.day2.medium;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * link: https://leetcode.com/problems/friend-circles/tabs/description
 */
public class FriendCircles {
   public class Solution {
      int count;
      int N;
      boolean[] marked;
      public int findCircleNum(int[][] M) {
         count = 0;
         N = M.length;
         marked = new boolean[N];
         for(int i=0; i < N; ++i) {
            if(!marked[i]){
               dfs(M, i);
               count++;
            }
         }
         return count;
      }

      private void dfs(int[][] M, int v) {
         marked[v] = true;
         for(int w=0; w < N; ++w) {
            if(M[v][w]==1) {
               if(!marked[w]) {
                  dfs(M, w);
               }
            }
         }
      }
   }

}
