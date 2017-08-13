package com.github.chen0040.leetcode.day06.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 */
public class BinaryLevelOrderTraversalII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         if(root == null) return result;
         Map<Integer, List<Integer>> levels = new HashMap<Integer, List<Integer>>();
         int depth = traverse(root, levels, 0);

         for(int i=depth-1; i >= 0; --i) {
            result.add(levels.get(i));
         }
         return result;
      }

      private int traverse(TreeNode x, Map<Integer, List<Integer>> levels, int d) {
         if(x == null) {
            return d;
         }
         int depth_left = traverse(x.left, levels, d+1);
         int val = x.val;
         if(levels.containsKey(d)) {
            levels.get(d).add(val);
         } else {
            List<Integer> level = new ArrayList<Integer>();
            level.add(val);
            levels.put(d, level);
         }
         int depth_right = traverse(x.right, levels, d+1);

         return Math.max(depth_left, depth_right);
      }
   }
}
