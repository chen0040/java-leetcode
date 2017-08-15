package com.github.chen0040.leetcode.day20.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 15/8/2017.
 *
 * link: https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 */
public class AddAndSearchWord {
   static class Node {
      boolean bit = false;
      int key;
      Node left;
      Node right;
      Node mid;
      public Node(int key) {
         this.key = key;
      }
   }

   static class Trie {




      private Node root;

      /** Initialize your data structure here. */
      public Trie() {

      }

      /** Inserts a word into the trie. */
      public void insert(String word) {
         root = insert(root, word, 0);
      }

      private Node insert(Node x, String word, int d) {
         int key = (int)word.charAt(d);
         if(x == null) {
            x = new Node(key);
         }

         if(key < x.key){
            x.left = insert(x.left, word, d);
         } else if(key > x.key) {
            x.right = insert(x.right, word, d);
         } else {
            if(d < word.length()-1) {
               x.mid = insert(x.mid, word, d+1);
            } else {
               x.bit = true;
            }
         }

         return x;
      }

      /** Returns if the word is in the trie. */
      public boolean search(String word) {
         List<Node> queue = new ArrayList<Node>();
         collect(root, word, 0, queue);
         boolean found = false;
         for(Node x : queue) {
            if(x.bit) {
               found = true;
               break;
            }
         }
         return found;
      }

      private void collect(Node x, String word, int d, List<Node> queue) {
         if(x == null) {
            return;
         }
         if(word.charAt(d) == '.') {
            if(d == word.length()-1) {
               queue.add(x);
            } else {
               collect(x.mid, word, d+1, queue);
               collect(x.left,word, d, queue);
               collect(x.right, word, d, queue);
            }
         } else {
            int key = (int)word.charAt(d);

            if(key < x.key) {
               collect(x.left, word, d, queue);
            } else if(key > x.key) {
               collect(x.right, word, d, queue);
            } else {
               if(d == word.length()-1) {
                  queue.add(x);
               } else {
                  collect(x.mid, word, d+1, queue);
               }
            }
         }
      }

   }

   public class WordDictionary {



      private Trie trie = new Trie();
      /** Initialize your data structure here. */
      public WordDictionary() {

      }

      /** Adds a word into the data structure. */
      public void addWord(String word) {
         trie.insert(word);
      }

      /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
      public boolean search(String word) {
         return trie.search(word);
      }
   }
}
