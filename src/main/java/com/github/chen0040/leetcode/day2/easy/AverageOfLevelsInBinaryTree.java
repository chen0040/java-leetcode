package com.github.chen0040.leetcode.day2.easy;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * link: https://leetcode.com/problems/average-of-levels-in-binary-tree/tabs/description
 */
public class AverageOfLevelsInBinaryTree {

   public static class TreeNode {
      int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class Solution {
     public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, Double> sums = new HashMap<Integer, Double>();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int levels = collect(root, 0, sums, counts);
        List<Double> result = new ArrayList<Double>();
        for (int i = 0; i < levels; ++i) {
           double sum = sums.getOrDefault(i, 0.0);
           int count = counts.getOrDefault(i, 0);
           if (count > 0) {
              result.add(sum / count);
           }
        }
        return result;
     }


     private int collect(TreeNode x, int level, Map<Integer, Double> sums, Map<Integer, Integer> counts) {
        if (x == null) {
           return level;
        }
        sums.put(level, sums.getOrDefault(level, 0.0) + x.val);
        counts.put(level, counts.getOrDefault(level, 0) + 1);
        int depth_left = collect(x.left, level + 1, sums, counts);
        int depth_right = collect(x.right, level + 1, sums, counts);
        return 1 + Math.max(depth_left, depth_right);
     }
  }
}
