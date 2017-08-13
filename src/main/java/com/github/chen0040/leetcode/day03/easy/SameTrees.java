package com.github.chen0040.leetcode.day03.easy;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * link: https://leetcode.com/problems/same-tree/description/
 */
public class SameTrees {
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

   public class Solution {
      public boolean isSameTree(TreeNode p, TreeNode q) {
         if((p == null && q != null) || (p != null && q == null)) return false;
         if(p==null && q==null) return true;
         if(p.val != q.val) return false;

         boolean sameLeftTree = isSameTree(p.left, q.left);
         boolean sameRightTree = isSameTree(p.right, q.right);
         return sameLeftTree && sameRightTree;
      }
   }
}
