package com.github.chen0040.leetcode.day02.medium;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * link: https://leetcode.com/problems/add-one-row-to-tree/tabs/description
 */
public class AddOneRowToTreeNode {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
   public class Solution {
      public TreeNode addOneRow(TreeNode root, int v, int d) {
         if(d==1) {
            TreeNode oldRoot = root;
            root = new TreeNode(v);
            root.left = oldRoot;
            return root;
         }
         return addOneRow(root, 1, v, d);
      }

      public TreeNode addOneRow(TreeNode x, int c, int v, int d) {
         if(x == null) {
            return null;
         }
         if(c == d-1) {
            TreeNode oldLeft = x.left;
            x.left = new TreeNode(v);
            x.left.left = oldLeft;
            TreeNode oldRight = x.right;
            x.right = new TreeNode(v);
            x.right.right = oldRight;
         } else {
            x.left = addOneRow(x.left, c+1, v, d);
            x.right = addOneRow(x.right, c+1, v, d);
         }

         return x;
      }
   }
}
