package com.github.chen0040.leetcode.day11.easy;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 6/8/2017.
 *
 * summary:
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * link: https://leetcode.com/contest/leetcode-weekly-contest-44/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      boolean found;
      public boolean findTarget(TreeNode root, int k) {
         found = false;
         Set<Integer> rems = new HashSet<Integer>();
         find(root, k, rems);
         return found;
      }

      private void find(TreeNode x, int k, Set<Integer> rems) {
         if(x == null) {
            return;
         }

         if(rems.contains(x.val)) {
            found = true;
            return;
         }

         rems.add(k - x.val);

         find(x.left, k, rems);
         find(x.right, k, rems);
      }
   }
}
