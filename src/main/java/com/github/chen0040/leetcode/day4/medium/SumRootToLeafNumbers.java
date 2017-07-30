package com.github.chen0040.leetcode.day4.medium;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class SumRootToLeafNumbers {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      int sum = 0;
      public int sumNumbers(TreeNode root) {
         sum = 0;
         traverse(root, 0);
         return sum;
      }

      private void traverse(TreeNode x, int temp) {
         if(x == null) {
            return;
         }
         if(isLeave(x)) {
            sum += temp * 10 + x.val;
            return;
         }
         traverse(x.left, temp * 10 + x.val);
         traverse(x.right, temp * 10 + x.val);
      }

      private boolean isLeave(TreeNode x) {
         return x.left == null && x.right == null;
      }
   }
}
