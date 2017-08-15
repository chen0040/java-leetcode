package com.github.chen0040.leetcode.day20.medium;


/**
 * Created by xschen on 15/8/2017.
 *
 * link: https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class ImplementTrie {
   private static class Node {
      boolean bit = false;
      int key;
      Node left;
      Node right;
      Node mid;
      public Node(int key) {
         this.key = key;
      }
   }

   public class Trie {




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
         Node x = get(root, word, 0);
         if(x == null) {
            return false;
         } else {
            return x.bit;
         }
      }

      private Node get(Node x, String word, int d) {
         if(x == null) {
            return null;
         }
         int key = (int)word.charAt(d);
         if(key < x.key) {
            return get(x.left, word, d);
         } else if(key > x.key) {
            return get(x.right, word, d);
         } else {
            if(d == word.length()-1) {
               return x;
            } else {
               return get(x.mid, word, d+1);
            }
         }
      }

      /** Returns if there is any word in the trie that starts with the given prefix. */
      public boolean startsWith(String prefix) {
         Node x = get(root, prefix, 0);
         return x != null;
      }
   }
}
