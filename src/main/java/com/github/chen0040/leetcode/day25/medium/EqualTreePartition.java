package com.github.chen0040.leetcode.day25.medium;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 20/8/2017.
 *
 * summary:
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
 *
 */
public class EqualTreePartition {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   class Solution {
      Set<Integer> set = new HashSet<Integer>();
      public boolean checkEqualTree(TreeNode root) {
         int sum = treeSum(root);
         if(set.isEmpty()) return false;
         for(Integer num : set) {
            if(sum == num.intValue() * 2) {
               return true;
            }
         }
         return false;
      }

      private int treeSum(TreeNode x) {
         if(x == null) {
            return 0;
         }
         int val = x.val;
         int left_val = treeSum(x.left);
         int right_val = treeSum(x.right);

         if(x.left != null) set.add(left_val);
         if(x.right != null) set.add(right_val);

         int sum = val + left_val + right_val;



         return sum;
      }

   }
}
