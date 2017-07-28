package com.github.chen0040.leetcode.day1.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * link: https://leetcode.com/problems/binary-tree-preorder-traversal/tabs/description
 */
public class BinaryTreePreOrderTraversal {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> queue = new ArrayList<Integer>();
         collect(root, queue);
         return queue;
      }
      private void collect(TreeNode x, List<Integer> queue) {
         if(x == null) {
            return;
         }
         queue.add(x.val);
         collect(x.left, queue);
         collect(x.right, queue);
      }
   }
}
