package com.github.chen0040.leetcode.day10.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * link: https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class SubtreeOfAnotherTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
   public class Solution {
      public boolean isSubtree(TreeNode s, TreeNode t) {
         if(s == null && t == null) return true;
         if(s != null && t == null) return false;
         if(s == null && t != null) return false;

         if(s.val == t.val) {
            if(isSameTree(s.left, t.left) && isSameTree(s.right, t.right)) return true;
         }
         return isSubtree(s.left, t) || isSubtree(s.right, t);

      }

      private boolean isSameTree(TreeNode s, TreeNode t) {
         if(s == null && t == null) return true;
         if(s != null && t == null) return false;
         if(s == null && t != null) return false;
         if(s.val != t.val) return false;
         return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
      }
   }
}
