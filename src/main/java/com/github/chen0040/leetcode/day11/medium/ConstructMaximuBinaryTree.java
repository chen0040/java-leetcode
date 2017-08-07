package com.github.chen0040.leetcode.day11.medium;


/**
 * Created by xschen on 6/8/2017.
 *
 * summary:
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * link: https://leetcode.com/contest/leetcode-weekly-contest-44/problems/maximum-binary-tree/
 */
public class ConstructMaximuBinaryTree {

   public static void main(String[] args) {
      int[] nums = new int[] {3,2,1,6,0,5};
      Solution solution = new Solution();
      TreeNode x = solution.constructMaximumBinaryTree(nums);

   }
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public static class Solution {
      public TreeNode constructMaximumBinaryTree(int[] nums) {
         return build(null, nums, 0, nums.length-1);
      }

      private TreeNode build(TreeNode x, int[] nums, int lo, int hi) {
         if(lo > hi) return null;
         if(x == null) {
            int maxNumIndex = -1;
            int maxNum = Integer.MIN_VALUE;
            for(int i=lo; i <= hi; ++i) {
               int num = nums[i];
               if(num > maxNum) {
                  maxNum = num;
                  maxNumIndex = i;
               }
            }
            x = new TreeNode(maxNum);

            x.left = build(x.left, nums, lo, maxNumIndex-1);
            x.right = build(x.right, nums, maxNumIndex+1, hi);
         }

         return x;
      }
   }
}
