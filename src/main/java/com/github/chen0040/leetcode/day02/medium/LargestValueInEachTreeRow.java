package com.github.chen0040.leetcode.day02.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * You need to find the largest value in each row of a binary tree.
 *
 * link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/tabs/description
 */
public class LargestValueInEachTreeRow {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
   public class Solution {
      public List<Integer> largestValues(TreeNode root) {
         Map<Integer, Integer> levels = new HashMap<Integer, Integer>();
         List<Integer> result = new ArrayList<Integer>();
         if(root == null) return result;
         int maxDepth = collect(root, 0, levels);

         for(int i=0; i <= maxDepth; ++i) {
            result.add(levels.get(i));
         }
         return result;
      }

      private int collect(TreeNode x, int d, Map<Integer, Integer> levels) {
         if(x == null){
            return d-1;
         }

         if(levels.containsKey(d)){
            levels.put(d, Math.max(levels.get(d), x.val));
         } else {
            levels.put(d, x.val);
         }
         int depth_left = collect(x.left, d+1, levels);
         int depth_right = collect(x.right, d+1, levels);
         return Math.max(depth_left, depth_right);
      }
   }
}
