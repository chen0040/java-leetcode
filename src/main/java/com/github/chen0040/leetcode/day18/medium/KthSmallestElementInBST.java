package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      private int count = 0;
      private TreeNode target = null;
      public int kthSmallest(TreeNode root, int k) {
         count = 0;
         target = null;
         preorder(root, k);
         return target.val;
      }

      private void preorder(TreeNode x, int k) {
         if(x == null) {
            return;
         }
         preorder(x.left, k);
         count++;
         if(count == k) {
            target = x;
            return;
         }

         preorder(x.right, k);
      }
   }
}
