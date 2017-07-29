package com.github.chen0040.leetcode.day3;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Find the sum of all left leaves in a given binary tree.
 *
 * link: https://leetcode.com/problems/sum-of-left-leaves/description/
 */
public class SumOfLeftLeaves {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public int sumOfLeftLeaves(TreeNode root) {
         return sumOfLeftLeaves(root, 0);
      }
      public int sumOfLeftLeaves(TreeNode x, int sum) {
         if(x == null) {
            return sum;
         }
         int inc = 0;
         if( x.left != null && x.left.left == null && x.left.right == null) inc = x.left.val;
         sum = sumOfLeftLeaves(x.left, sum + inc);
         sum = sumOfLeftLeaves(x.right, sum);
         return sum;
      }
   }
}
