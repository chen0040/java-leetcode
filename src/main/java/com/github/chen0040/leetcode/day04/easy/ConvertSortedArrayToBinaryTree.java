package com.github.chen0040.leetcode.day04.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class ConvertSortedArrayToBinaryTree {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public TreeNode sortedArrayToBST(int[] nums) {
         int lo = 0;
         int hi = nums.length-1;
         return sortedArrayToBST(nums, lo, hi);
      }

      private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
         if(lo > hi) {
            return null;
         }

         int mid = (hi + lo) / 2;
         TreeNode x = new TreeNode(nums[mid]);
         x.left = sortedArrayToBST(nums, lo, mid - 1);
         x.right = sortedArrayToBST(nums, mid+1, hi);
         return x;
      }
   }
}
