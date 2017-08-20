package com.github.chen0040.leetcode.day25.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 20/8/2017.
 *
 * summary:
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidthOfBinaryTree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   class Solution {
      Map<Integer, Integer> max_levels = new HashMap<Integer, Integer>();
      Map<Integer, Integer> min_levels = new HashMap<Integer, Integer>();

      public int widthOfBinaryTree(TreeNode root) {
         int depth = collect(root, 0, 0);
         int max = 0;
         if(root != null) max = 1;
         for(int d = depth; d >= 0; --d) {
            if(max_levels.containsKey(d) && min_levels.containsKey(d)) {
               //System.out.println("max: " + max_levels.get(d));
               //System.out.println("min: " + min_levels.get(d));
               if(max_levels.get(d).intValue() == min_levels.get(d)) continue;
               max = Math.max(max_levels.get(d) - min_levels.get(d) + 1, max);
            }
         }
         return max;
      }

      private int collect(TreeNode x, int d, int pos) {
         if(x == null) {
            return d;
         }

         if(max_levels.containsKey(d)) {
            max_levels.put(d, Math.max(max_levels.get(d), pos));
         } else {
            max_levels.put(d, pos);
         }

         if(min_levels.containsKey(d)) {
            min_levels.put(d, Math.min(min_levels.get(d), pos));
         } else {
            min_levels.put(d, pos);
         }

         int left_depth = collect(x.left, d+1, pos << 1 );
         int right_depth = collect(x.right, d+1, (pos << 1) +1);
         return Math.max(left_depth, right_depth);
      }
   }
}
