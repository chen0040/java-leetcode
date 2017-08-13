package com.github.chen0040.leetcode.day04.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * link: https://leetcode.com/problems/symmetric-tree/description/
 */
public class SymmetricTree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public boolean isSymmetric(TreeNode root) {
         if(root == null) return true;

         return isMirror(root.left, root.right);
      }

      private boolean isMirror(TreeNode left, TreeNode right) {
         if(left == null && right == null) return true;
         if(left != null && right == null) return false;
         if(left == null && right != null) return false;
         if(left.val != right.val) return false;
         if(isMirror(left.left, right.right) && isMirror(left.right, right.left)) {
            return true;
         }
         return false;
      }
   }
}
