package com.github.chen0040.leetcode.day09.medium;


/**
 * Created by xschen on 4/8/2017.
 *
 * summary:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class ConstructBinaryTreesFromPreorderAndInorderTraversals {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

   public class Solution {
      public TreeNode buildTree(int[] preorder, int[] inorder) {
         return build(0, 0, inorder.length-1, preorder, inorder);
      }

      private TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
         if(preStart > preorder.length-1 || inStart > inEnd) {
            return null;
         }
         int inIndex = 0;
         TreeNode root = new TreeNode(preorder[preStart]);
         for(int i = inStart; i <= inEnd; ++i){
            if(inorder[i] == root.val) {
               inIndex = i;
               break;
            }
         }

         root.left = build(preStart+1, inStart, inIndex-1, preorder, inorder);
         root.right = build(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

         return root;
      }
   }
}
