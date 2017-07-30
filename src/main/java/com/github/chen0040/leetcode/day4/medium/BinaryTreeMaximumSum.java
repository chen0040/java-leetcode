package com.github.chen0040.leetcode.day4.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class BinaryTreeMaximumSum {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      int maxValue;

      public int maxPathSum(TreeNode root) {
         maxValue = Integer.MIN_VALUE;
         maxPathDown(root);
         return maxValue;
      }

      private int maxPathDown(TreeNode node) {
         if (node == null) return 0;
         int left = Math.max(0, maxPathDown(node.left));
         int right = Math.max(0, maxPathDown(node.right));
         maxValue = Math.max(maxValue, left + right + node.val);
         return Math.max(left, right) + node.val;
      }
   }
}
