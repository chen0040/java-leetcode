package com.github.chen0040.leetcode.day7.medium;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * link: https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class ValidBST {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public boolean isValidBST(TreeNode root) {
         if(root == null) return true;
         return isSmaller(root.left, root.val) && isGreater(root.right, root.val);
      }

      private boolean isSmaller(TreeNode x, int val) {
         if(x == null) {
            return true;
         }
         if(x.val >= val) {
            return false;
         }
         if(!isSmaller(x.left, Math.min(x.val, val))) {
            return false;
         }
         if(!isGreater(x.right, x.val)) {
            return false;
         }
         if(!isSmaller(x.right, val)) {
            return false;
         }
         return true;
      }
      private boolean isGreater(TreeNode x, int val) {
         if(x == null) {
            return true;
         }
         if(x.val <= val) {
            return false;
         }
         if(!isGreater(x.left, val)) {
            return false;
         }
         if(!isSmaller(x.left, x.val)) {
            return false;
         }
         if(!isGreater(x.right, Math.max(x.val, val))) {
            return false;
         }
         return true;
      }


   }
}
