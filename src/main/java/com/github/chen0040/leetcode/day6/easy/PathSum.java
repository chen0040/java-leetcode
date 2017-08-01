package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * link: https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      boolean hasPath;
      int target;
      public boolean hasPathSum(TreeNode root, int sum) {
         hasPath = false;
         target = sum;
         if(root == null) return false;
         reduce(root, 0);
         return hasPath;
      }

      private void reduce(TreeNode x, int sum){
         if(x == null) {
            return;
         }

         if(isLeave(x)) {
            if(sum + x.val == target) {
               hasPath = true;
            }
            return;
         }

         reduce(x.left, sum + x.val);
         reduce(x.right, sum + x.val);
      }

      private boolean isLeave(TreeNode x) {
         return x.left == null && x.right == null;
      }
   }
}
