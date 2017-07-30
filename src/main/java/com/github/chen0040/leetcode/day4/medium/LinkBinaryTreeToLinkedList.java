package com.github.chen0040.leetcode.day4.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
public class LinkBinaryTreeToLinkedList {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public void flatten(TreeNode root) {
         List<Integer> queue = new ArrayList<Integer>();
         collect(root, queue);
         TreeNode x = null;
         for(int i=0; i < queue.size(); ++i) {
            if(i == 0) {
               root.val = queue.get(i);
               root.left = null;
               root.right = null;
               x = root;
               continue;
            }
            TreeNode oldX = x;
            x = new TreeNode(queue.get(i));
            oldX.right = x;
         }
      }

      private void collect(TreeNode x, List<Integer> queue) {
         if(x == null) {
            return;
         }
         queue.add(x.val);
         collect(x.left, queue);

         collect(x.right, queue);
      }
   }
}
