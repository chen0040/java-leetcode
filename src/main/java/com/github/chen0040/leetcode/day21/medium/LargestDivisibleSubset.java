package com.github.chen0040.leetcode.day21.medium;


import java.util.*;


/**
 * Created by xschen on 16/8/2017.
 *
 * link: https://leetcode.com/problems/largest-divisible-subset/description/
 */
public class LargestDivisibleSubset {
   static class Graph {
      int V;
      List<Integer>[] adjList;
      Set<Integer> sources = new HashSet<Integer>();
      Set<Integer> targets = new HashSet<Integer>();
      public Graph(int V) {
         this.V = V;
         adjList = (List<Integer>[])new List[V];
         for(int v = 0; v < V; ++v) {
            adjList[v] = new ArrayList<Integer>();
            sources.add(v);
            targets.add(v);
         }
      }

      public void addEdge(int v, int w) {
         sources.remove(w);
         targets.remove(v);
         adjList[v].add(w);
      }

      public List<Integer> adj(int v) {
         return adjList[v];
      }
   }

   public class Solution {




      public List<Integer> largestDivisibleSubset(int[] nums) {
         if(nums.length <= 1) {
            List<Integer> a = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; ++i) {
               a.add(nums[i]);
            }
            return a;
         }
         Arrays.sort(nums);
         Graph g = new Graph(nums.length);
         for(int i=0; i < nums.length; ++i) {
            for(int j=i+1; j < nums.length; ++j) {
               if(nums[j] % nums[i] == 0) {
                  g.addEdge(i, j);
               }
            }
         }

         Set<Integer> sources = g.sources;
         int maxCost = 0;
         List<Integer> path = new ArrayList<Integer>();
         for(Integer s : sources) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(s);
            boolean[] marked = new boolean[g.V];
            int[] edgeTo = new int[g.V];
            int[] costs = new int[g.V];
            while(!queue.isEmpty()) {
               int v = queue.remove();
               marked[v] = true;
               for(Integer w : g.adj(v)){
                  if(costs[w] < costs[v] + 1) {
                     costs[w] = costs[v] + 1;
                     edgeTo[w] = v;
                  }
                  if(!marked[w]) {
                     queue.add(w);
                  }
               }
            }

            int maxV = -1;

            for(int v = 0; v < costs.length; ++v){
               if(costs[v] > maxCost) {
                  maxCost = costs[v];
                  maxV = v;
               }
            }

            if(maxV != -1) {
               Stack<Integer> stack = new Stack<Integer>();
               int x = maxV;
               while(x != s) {
                  stack.push(x);
                  x = edgeTo[x];
               }
               stack.push(s);
               path.clear();
               while(!stack.isEmpty()) {
                  path.add(nums[stack.pop()]);
               }
            }

         }

         if(path.isEmpty()) {
            path.add(nums[0]);
         }

         return path;


      }
   }
}
