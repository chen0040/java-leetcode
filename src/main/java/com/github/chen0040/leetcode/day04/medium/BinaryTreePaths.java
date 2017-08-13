package com.github.chen0040.leetcode.day04.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree, return all root-to-leaf paths.
 *
 * link: https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public List<String> binaryTreePaths(TreeNode root) {
         List<String> queue = new ArrayList<String>();
         collect(root, queue, "");
         return queue;
      }

      private void collect(TreeNode x, List<String> queue, String prefix) {
         if(x == null) {
            return;
         }
         if(prefix.equals("")) {
            prefix = "" + x.val;
         } else {
            prefix = prefix + "->" + x.val;
         }
         if(x.left == null && x.right == null) {
            queue.add(prefix);
         }
         collect(x.left, queue, prefix);
         collect(x.right, queue, prefix);
      }
   }
}
