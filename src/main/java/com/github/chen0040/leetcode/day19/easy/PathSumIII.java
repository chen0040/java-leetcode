package com.github.chen0040.leetcode.day19.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 14/8/2017.
 *
 * link: https://leetcode.com/problems/path-sum-iii/description/
 */
public class PathSumIII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      int count = 0;

      public int pathSum(TreeNode root, int sum) {
         count = 0;
         Map<Integer, Integer> preSums = new HashMap<Integer, Integer>();
         preSums.put(0, 1);
         collect2(root, sum, 0, preSums);
         return count;
      }

      private void collect2(TreeNode x, int target, int currSum, Map<Integer, Integer> preSums) {
         if(x == null) {
            return;
         }

         currSum+=x.val;

         if(preSums.containsKey(currSum - target)) {
            count += preSums.get(currSum - target);
         }

         preSums.put(currSum, preSums.getOrDefault(currSum, 0) + 1);

         collect2(x.left, target, currSum, preSums);
         collect2(x.right, target, currSum, preSums);

         preSums.put(currSum, preSums.get(currSum) - 1);
      }
   }
}
