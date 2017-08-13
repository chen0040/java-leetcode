package com.github.chen0040.leetcode.day04.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * link: https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public class Solution {
      public List<Integer> rightSideView(TreeNode root) {
         Map<Integer, Integer> queue = new HashMap<Integer, Integer>();
         int depth = collect(root, queue, 0);
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < depth; ++i){
            result.add(queue.get(i));
         }
         return result;
      }

      private int collect(TreeNode x, Map<Integer, Integer> queue, int d) {
         if(x == null) {
            return d;
         }

         queue.put(d, x.val);

         int depth_left = collect(x.left, queue, d+1);
         int depth_right = collect(x.right, queue, d+1);

         return Math.max(depth_left, depth_right);
      }

      private boolean isLeave(TreeNode x) {
         return x.left == null && x.right == null;
      }

   }
}
