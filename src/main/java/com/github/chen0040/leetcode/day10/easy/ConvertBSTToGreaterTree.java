package com.github.chen0040.leetcode.day10.easy;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * link: https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */
public class ConvertBSTToGreaterTree {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public TreeNode convertBST(TreeNode root) {
         List<Integer> queue = new ArrayList<Integer>();
         inorder(root, queue);
         Stack<Integer> sums = new Stack<Integer>();;

         int sum = 0;
         for(int i=queue.size()-1; i >= 0; --i){
            sum += queue.get(i);
            sums.push(sum);
         }
         inorder2(root, sums);

         return root;
      }

      private void inorder2(TreeNode x, Stack<Integer> sums){
         if(x == null){
            return;
         }
         inorder2(x.left, sums);
         x.val = sums.pop();
         inorder2(x.right, sums);
      }

      private void inorder(TreeNode x, List<Integer> queue){
         if(x == null){
            return;
         }
         inorder(x.left, queue);
         queue.add(x.val);
         inorder(x.right, queue);
      }
   }
}
