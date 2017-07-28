package com.github.chen0040.leetcode.day2.easy;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Invert a binary tree.
 *
 * link: https://leetcode.com/problems/invert-binary-tree/tabs/description
 */
public class InvertBinaryTree {

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
   public TreeNode invertTree(TreeNode root) {
      if(root == null) {
         return null;
      }
      root.left = invertTree(root.left);
      root.right = invertTree(root.right);
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      return root;
   }
}
