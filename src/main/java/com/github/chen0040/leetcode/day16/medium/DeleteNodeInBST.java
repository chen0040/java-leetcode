package com.github.chen0040.leetcode.day16.medium;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/delete-node-in-a-bst/description/
 */
public class DeleteNodeInBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      private TreeNode min(TreeNode x) {
         if(x.left == null) {
            return x;
         }
         return min(x.left);
      }

      private TreeNode delMin(TreeNode x) {
         if(x.left == null) {
            return x.right;
         }
         x.left = delMin(x.left);
         return x;
      }
      public TreeNode deleteNode(TreeNode root, int key) {
         if(root == null) {
            return null;
         }

         if(key < root.val) {
            root.left = deleteNode(root.left, key);
         } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
         } else {
            if(root.left == null) {
               root = root.right;
            } else if(root.right == null) {
               root = root.left;
            } else {
               TreeNode m = min(root.right);
               m.right = delMin(root.right);
               m.left = root.left;
               root = m;
            }
         }

         return root;
      }


   }
}
