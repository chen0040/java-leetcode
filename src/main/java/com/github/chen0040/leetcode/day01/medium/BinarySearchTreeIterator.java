package com.github.chen0040.leetcode.day01.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * link: https://leetcode.com/problems/binary-search-tree-iterator/tabs/description
 */
public class BinarySearchTreeIterator {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class BSTIterator {

      private int pos;
      private List<Integer> queue;
      public BSTIterator(TreeNode root) {
         queue = new ArrayList<Integer>();
         collect(root, queue);
         pos = 0;
      }

      private void collect(TreeNode x, List<Integer> queue) {
         if(x == null) {
            return;
         }
         collect(x.left, queue);
         queue.add(x.val);
         collect(x.right, queue);
      }

      /** @return whether we have a next smallest number */
      public boolean hasNext() {
         return pos < queue.size();
      }

      /** @return the next smallest number */
      public int next() {
         return queue.get(pos++);
      }
   }
}
