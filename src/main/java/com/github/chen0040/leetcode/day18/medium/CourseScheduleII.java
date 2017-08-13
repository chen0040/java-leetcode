package com.github.chen0040.leetcode.day18.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseScheduleII {

   static class Graph {
      int V;
      List<Integer>[] adjList;
      public Graph(int V) {
         this.V = V;
         adjList =(List<Integer>[])new List[V];
         for(int v = 0; v < V; ++v) {
            adjList[v] = new ArrayList<Integer>();
         }
      }

      public List<Integer> adj(int v) {
         return adjList[v];
      }

      public void addEdge(int v, int w){
         adj(v).add(w);
      }

      private boolean hasCycle;
      public int[] topoSort() {
         hasCycle = false;
         boolean[] marked = new boolean[V];
         boolean[] onStack = new boolean[V];
         Stack<Integer> postOrder = new Stack<Integer>();
         for(int v = 0; v < V; ++v) {
            if(!marked[v]) {
               dfs(v, marked, postOrder, onStack);
            }
         }

         if(hasCycle){
            return new int[0];
         } else {
            int[] result = new int[V];
            int index = 0;
            while(!postOrder.isEmpty()) {
               result[index++] = postOrder.pop();
            }
            return result;
         }
      }

      private void dfs(int v, boolean[] marked, Stack<Integer> postOrder, boolean[] onStack) {
         marked[v] = true;
         onStack[v] = true;
         List<Integer> adj_v = adj(v);
         for(Integer w : adj_v){
            if(onStack[w]){
               hasCycle = true;
            }
            if(!marked[w]) {
               dfs(w, marked, postOrder, onStack);
            }
         }
         postOrder.push(v);
         onStack[v] = false;
      }

   }

   public class Solution {


      public int[] findOrder(int numCourses, int[][] prerequisites) {
         Graph g = new Graph(numCourses);
         for(int i=0; i < prerequisites.length; ++i) {
            int[] pre = prerequisites[i];
            int from = pre[1];
            int to = pre[0];
            g.addEdge(from, to);
         }

         return g.topoSort();
      }
   }
}
