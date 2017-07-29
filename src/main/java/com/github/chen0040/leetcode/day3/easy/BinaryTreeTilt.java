package com.github.chen0040.leetcode.day3.easy;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * link: https://leetcode.com/problems/binary-tree-tilt/description/
 */
public class BinaryTreeTilt {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public int findTilt(TreeNode root) {
      if(root == null) return 0;
      int sum_left = findSum(root.left);
      int sum_right = findSum(root.right);
      int tilt = Math.abs(sum_left - sum_right);
      int tilt_left = findTilt(root.left);
      int tilt_right = findTilt(root.right);
      return tilt + tilt_left + tilt_right;
   }

   public int findSum(TreeNode root) {
      if(root == null) {
         return 0;
      }
      int sum = root.val;
      sum += findSum(root.left);
      sum += findSum(root.right);
      return sum;
   }
}
