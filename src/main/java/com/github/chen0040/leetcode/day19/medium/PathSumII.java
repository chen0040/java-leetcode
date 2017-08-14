package com.github.chen0040.leetcode.day19.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumII {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      private List<List<Integer>> paths;
      public List<List<Integer>> pathSum(TreeNode root, int sum) {
         paths = new ArrayList<List<Integer>>();
         collect(root, sum, 0, new ArrayList<Integer>());
         return paths;
      }

      private void collect(TreeNode x, int target, int currSum, List<Integer> path){
         if(x == null) return;

         currSum += x.val;

         path = new ArrayList<Integer>(path);
         path.add(x.val);

         if(x.left == null && x.right == null && currSum == target){
            paths.add(path);
         }

         collect(x.left, target, currSum, path);
         collect(x.right, target, currSum, path);
      }
   }
}
