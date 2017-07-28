package com.github.chen0040.leetcode.day1.easy;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * link: https://leetcode.com/problems/merge-two-binary-trees/tabs/description
 */
public class MergeTwoBinaryTrees {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class Solution {
     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
           return null;
        TreeNode x = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        x.left = mergeTrees((t1 == null ? null : t1.left), (t2 == null ? null : t2.left));
        x.right = mergeTrees((t1 == null ? null : t1.right), (t2 == null ? null : t2.right));
        return x;

     }
  }
}
