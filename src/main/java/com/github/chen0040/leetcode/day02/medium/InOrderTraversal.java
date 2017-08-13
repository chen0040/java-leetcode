package com.github.chen0040.leetcode.day02.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Created by xschen on 28/7/2017.
 *
 * summary:
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 *
 * link: https://leetcode.com/problems/binary-tree-inorder-traversal/tabs/description
 */
public class InOrderTraversal {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
   public class Solution {
      public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
         if(root == null) return result;
         Stack<TreeNode> stack = new Stack<TreeNode>();
         stack.push(root);
         while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null){
               result.add(node.val);
               continue;
            }
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            node.right = null;
            if(right != null) {
               stack.push(right);
            }
            stack.push(node);
            if(left != null) {
               stack.push(left);
            }
         }
         return result;

      }
   }
}
