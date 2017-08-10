package com.github.chen0040.leetcode.day15.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class MaximumLengthOfPairChain {
   static class Graph {
      int V;
      List<Integer>[] adj;
      public Graph(int V){
         this.V = V;
         adj = (List<Integer>[])new List[V];
         for(int v = 0; v < V; ++v){
            adj[v] = new ArrayList<Integer>();
         }
      }

      public void addEdge(int v, int w) {
         adj[v].add(w);
      }
   }

   public class Solution {

      public int findLongestChain(int[][] pairs) {
         int s = -1;
         int min = Integer.MAX_VALUE;
         Graph g = new Graph(pairs.length);
         for(int i=0; i < pairs.length; ++i) {
            if(pairs[i][1] < min) {
               min = pairs[i][1];
               s = i;
            }
            for(int j = 0; j < pairs.length; ++j){
               if(i == j) continue;
               if(pairs[i][1] < pairs[j][0]){
                  g.addEdge(i, j);
               }
            }
         }

         int result = 0;

         int[] cost = new int[g.V];
         boolean[] marked = new boolean[g.V];
         dfs(g, s, cost, marked);

         for(int i=0; i < g.V; ++i) {
            result = Math.max(cost[i], result);
         }



         return result + 1;
      }

      private void dfs(Graph g, int v, int[] cost, boolean[] marked) {
         marked[v] = true;
         List<Integer> adj_v = g.adj[v];
         for(Integer w : adj_v) {
            if(cost[w] < cost[v] + 1) {
               cost[w] = cost[v] + 1;
               dfs(g, w, cost, marked);
            }

         }
      }
   }
}
