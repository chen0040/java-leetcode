package com.github.chen0040.leetcode.day17.medium;


import java.util.*;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/evaluate-division/description/
 */
public class EvaluateDivision {
   static class Edge {
      boolean inverse = false;
      double value;
      String from;
      String to;
      public Edge(String from, String to, double value, boolean inverse) {
         this.from = from;
         this.to = to;
         this.value = value;
         this.inverse = inverse;
      }

      public double compute() {
         if(inverse) return 1.0 / value;
         return value;
      }

      public String toString(){
         return from + "->" + to;
      }
   }

   static class Graph {
      Map<String, List<Edge>> adjList = new HashMap<String, List<Edge>>();
      public void addEdge(String from, String to, double value) {
         Edge e1 = new Edge(from, to, value, false);
         adj(from).add(e1);
         Edge e2 = new Edge(to, from, value, true);
         adj(to).add(e2);

      }

      public List<Edge> adj(String v){
         List<Edge> adj_v = null;
         if(adjList.containsKey(v)) {
            adj_v = adjList.get(v);
         } else {
            adj_v = new ArrayList<Edge>();
            adjList.put(v, adj_v);
         }
         return adj_v;
      }

      public double search(String s, String t) {
         Set<String> marked = new HashSet<String>();
         Queue<String> queue = new LinkedList<String>();
         Map<String, Edge> edgeTo = new HashMap<String, Edge>();

         Map<String, Double> costs = new HashMap<String, Double>();


         queue.add(s);
         costs.put(s, 0.0);
         while(!queue.isEmpty()) {
            String v = queue.remove();
            marked.add(v);
            if(v.equals(t)) {
               break;
            }
            List<Edge> adj_v = adj(v);
            for(Edge e : adj_v){
               String w = e.to;
               if(!costs.containsKey(w) || costs.get(w) > costs.get(v) + 1) {
                  edgeTo.put(w, e);
                  costs.put(w, costs.get(v) + 1);
                  if(!marked.contains(w)) {
                     queue.add(w);
                  }
               }
            }
         }


         if(marked.contains(t)){
            String x = t;
            Stack<Edge> stack = new Stack<Edge>();
            while(!x.equals(s)) {

               Edge e = edgeTo.get(x);
               stack.push(e);
               x = e.from;
            }

            List<Edge> path = new ArrayList<Edge>();
            while(!stack.isEmpty()) {
               path.add(stack.pop());
            }

            double result = 1.0;
            for(int i=0; i < path.size(); ++i) {
               result = result * path.get(i).compute();
            }
            return result;
         } else {
            return -1.0;
         }


      }
   }


   public class Solution {

      public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

         Set<String> known = new HashSet<String>();

         Graph g = new Graph();
         for(int i=0; i < equations.length; ++i) {
            String[] equation = equations[i];
            String from = equation[0];
            String to = equation[1];
            known.add(from);
            known.add(to);

            double value = values[i];
            g.addEdge(from, to, value);
         }

         double[] result = new double[queries.length];
         for(int i=0; i < queries.length; ++i) {
            String[] query = queries[i];
            String from = query[0];
            String to = query[1];
            if(from.equals(to)) {
               if(!known.contains(from)) {
                  result[i] = -1.0;
               } else {
                  result[i] = 1.0;
               }
            } else {
               result[i] = g.search(from, to);
            }
         }

         return result;

      }
   }
}
