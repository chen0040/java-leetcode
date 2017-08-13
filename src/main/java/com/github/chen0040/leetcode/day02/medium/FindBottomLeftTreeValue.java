package com.github.chen0040.leetcode.day02.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * link: https://leetcode.com/problems/find-bottom-left-tree-value/tabs/description
 */
public class FindBottomLeftTreeValue {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class Solution {
     public int findBottomLeftValue(TreeNode root) {

        Map<Integer, TreeNode> levels = new HashMap<Integer, TreeNode>();
        int depth = collect(root, 0, levels);

        return levels.get(depth).val;
     }
     private int collect(TreeNode x, int index, Map<Integer, TreeNode> levels) {
        if(x == null) {
           return index-1;
        }
        if(!levels.containsKey(index)) {
           levels.put(index, x);
        }

        int left_depth = collect(x.left, index + 1, levels);
        int right_depth = collect(x.right, index + 1, levels);

        return Math.max(left_depth, right_depth);
     }
  }
}
