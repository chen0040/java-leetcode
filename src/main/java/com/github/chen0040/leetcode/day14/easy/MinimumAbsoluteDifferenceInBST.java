package com.github.chen0040.leetcode.day14.easy;


import java.util.*;


/**
 * Created by xschen on 9/8/2017.
 *
 * summary:
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 */
public class MinimumAbsoluteDifferenceInBST {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public class Solution {
      public int getMinimumDifference(TreeNode root) {
         Set<Integer> values = new HashSet<Integer>();
         collect(root, values);
         List<Integer> list = new ArrayList<Integer>(values);
         Collections.sort(list);
         if(list.size() < 2)  return 0;
         int minDiff = Integer.MAX_VALUE;
         for(int i=1; i < list.size(); ++i) {
            minDiff = Math.min(minDiff, list.get(i) - list.get(i-1));
         }
         return minDiff;
      }

      private void collect(TreeNode x, Set<Integer> set) {
         if(x == null) {
            return;
         }

         collect(x.left, set);
         set.add(x.val);
         collect(x.right, set);
      }
   }
}
