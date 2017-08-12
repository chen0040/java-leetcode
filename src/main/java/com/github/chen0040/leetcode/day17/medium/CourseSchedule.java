package com.github.chen0040.leetcode.day17.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {
   static class Edge {
      int from;
      int to;

      public Edge(int from, int to) {
         this.from = from;
         this.to = to;
      }
   }

   static class Graph {
      private List<Edge>[] adjList;
      private int V;
      public Graph(int V){
         this.V = V;
         this.adjList = (List<Edge>[])new List[V];
         for(int v = 0; v < V; ++v) {
            adjList[v] = new ArrayList<Edge>();
         }
      }

      public void addEdge(int from, int to) {
         adjList[from].add(new Edge(from, to));
      }

      public List<Edge> adj(int v) {
         return adjList[v];
      }




   }

   public class Solution {



      boolean[] onStack;
      boolean[] marked;
      boolean hasCycle;
      public boolean detectCycles(Graph g) {
         marked = new boolean[g.V];
         onStack = new boolean[g.V];
         hasCycle = false;

         for(int v = 0; v < g.V; ++v){
            if(!marked[v]) {
               if(dfs(g, v)){
                  break;
               }
            }
         }
         return hasCycle;
      }

      private boolean dfs(Graph g, int v){
         marked[v] = true;
         onStack[v] = true;
         List<Edge> adj_v = g.adj(v);
         for(Edge e : adj_v) {
            int w = e.to;
            if(onStack[w]){
               hasCycle = true;
               return true;
            }
            if(!marked[w]) {
               dfs(g, w);
            }
         }
         onStack[v] = false;
         return false;
      }

      public boolean canFinish(int numCourses, int[][] prerequisites) {
         if(prerequisites.length == 0) return true;
         Graph g = new Graph(numCourses);
         Set<Integer> set = new HashSet<Integer>();
         for(int i=0; i < prerequisites.length; ++i) {
            int[] pre = prerequisites[i];
            int from = pre[1];
            int to = pre[0];
            set.add(from);
            set.add(to);
            g.addEdge(from, to);
         }

         return !detectCycles(g);


      }
   }
}
