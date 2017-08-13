package com.github.chen0040.leetcode.day07.medium;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * link: https://leetcode.com/problems/unique-binary-search-trees/description/
 */
public class UniqueBinarySearchTrees {
   public class Solution {
      public int numTrees(int n) {
         int[] G = new int[n+1];
         G[0]= G[1] = 1;
         for(int i=2; i <= n; ++i){
            for(int j = 1; j <= i; ++j) {
               G[i] += G[j-1] * G[i-j];
            }
         }
         return G[n];
      }
   }
}
