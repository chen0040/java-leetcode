package com.github.chen0040.leetcode.day4.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * link: https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterOfBinaryTree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public int diameterOfBinaryTree(TreeNode x) {
         if(x == null) {
            return 0;
         }

         int left_depth = depth(x.left);
         int right_depth = depth(x.right);
         int len = left_depth + right_depth;

         int left_len = diameterOfBinaryTree(x.left);
         int right_len = diameterOfBinaryTree(x.right);

         return Math.max(len, Math.max(left_len, right_len));
      }

      private int depth(TreeNode x) {
         if(x == null) {
            return 0;
         }
         return 1 + Math.max(depth(x.left), depth(x.right));
      }

   }
}
