package com.github.chen0040.leetcode.day4.medium;


import java.util.*;


/**
 * Created by xschen on 30/7/2017.
 *
 * link: https://leetcode.com/problems/clone-graph/description/
 */
public class CloneGraph
{
   public static void main(String[] args) {
      UndirectedGraphNode node1 = new UndirectedGraphNode(1);
      UndirectedGraphNode node2 = new UndirectedGraphNode(2);
      join(node1, node2);
      Solution s = new Solution();
      UndirectedGraphNode nodeClone1 = s.cloneGraph(node1);

      traverse(nodeClone1);

   }

   private static void traverse(UndirectedGraphNode node) {
      Set<Integer> marked = new HashSet<>();
      traverse(node, marked);
   }

   private static void traverse(UndirectedGraphNode node, Set<Integer> marked) {
      if(node == null) return;
      marked.add(node.label);
      System.out.println(node.label);
      for(UndirectedGraphNode w : node.neighbors) {
         if(!marked.contains(w.label)) {
            traverse(w, marked);
         }
      }
   }

   private static void join(UndirectedGraphNode node1, UndirectedGraphNode node2) {
      node1.neighbors.add(node2);
      node2.neighbors.add(node1);
   }
     private static class UndirectedGraphNode {
     int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }

   public static class Solution {
      public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         if(node == null) return null;
         Map<Integer, UndirectedGraphNode> nodes = new HashMap<Integer, UndirectedGraphNode>();
         return cloneGraph(null, node, nodes);
      }

      private UndirectedGraphNode cloneGraph(UndirectedGraphNode clone, UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodes){
         if(clone == null) {
            clone = new UndirectedGraphNode(node.label);
            nodes.put(node.label, clone);
         }

         List<UndirectedGraphNode> adj = node.neighbors;
         for(int i=0; i < adj.size(); ++i) {
            UndirectedGraphNode w = adj.get(i);
            int w_label = w.label;
            UndirectedGraphNode w_clone = null;
            if(nodes.containsKey(w_label)){
               w_clone = nodes.get(w_label);
            } else {
               w_clone = cloneGraph(null, w, nodes);
            }
            clone.neighbors.add(w_clone);
         }

         return clone;
      }
   }
}
