package com.github.chen0040.leetcode.day18.medium;


import java.util.*;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder {

   static class Graph {
      Map<String, List<String>> adjList = new HashMap<String, List<String>>();
      public void addEdge(String v, String w) {
         adj(v).add(w);
         adj(w).add(v);
      }

      public List<String> adj(String v){
         if(adjList.containsKey(v)){
            return adjList.get(v);
         } else {
            List<String> list = new ArrayList<String>();
            adjList.put(v, list);
            return list;
         }
      }

      public int search(String s, String t) {
         Set<String> marked = new HashSet<String>();
         Map<String, Integer> costs = new HashMap<String, Integer>();
         Queue<String> queue = new LinkedList<String>();
         queue.add(s);
         costs.put(s, 0);
         while(!queue.isEmpty()) {
            String v= queue.remove();
            //System.out.println(v);
            List<String> adj_v = adj(v);
            marked.add(v);
            if(v.equals(t)) break;
            for(String w : adj_v){
               if(costs.getOrDefault(w, Integer.MAX_VALUE / 2) > costs.get(v) + 1) {
                  costs.put(w, costs.get(v) + 1);
                  if(!marked.contains(w)) {
                     queue.add(w);
                  }
               }
            }
         }

         if(costs.containsKey(t)) {
            return costs.get(t) + 1;
         } else {
            return 0;
         }
      }
   }

   public class Solution {



      public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Graph g = new Graph();
         wordList.add(beginWord);
         for(int i=0; i < wordList.size(); ++i) {
            String w1 = wordList.get(i);
            for(int j=i+1; j < wordList.size(); ++j) {
               String w2 = wordList.get(j);
               if(isConnected(w1, w2)) {
                  g.addEdge(w1, w2);
               }
            }
         }

         return g.search(beginWord, endWord);
      }

      private boolean isConnected(String w1, String w2) {
         if(w1.length() != w2.length()) return false;
         int count = 0;
         for(int i=0; i < w1.length(); ++i) {
            if(w1.charAt(i) != w2.charAt(i)) {
               count++;
            }
         }
         return count==1;
      }
   }
}
