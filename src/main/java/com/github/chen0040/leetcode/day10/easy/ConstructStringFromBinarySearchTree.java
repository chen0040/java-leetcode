package com.github.chen0040.leetcode.day10.easy;


/**
 * Created by xschen on 5/8/2017.
 *
 * link: https://leetcode.com/problems/construct-string-from-binary-tree/description/
 */
public class ConstructStringFromBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public String tree2str(TreeNode t) {
         if(t == null){
            return "";
         }

         String result = "" + t.val;
         if(t.left == null && t.right != null) {
            result = result + "()(" + tree2str(t.right) + ")";
         } else if(t.left != null && t.right == null) {
            result = result + "(" + tree2str(t.left) + ")";
         } else if(t.left != null && t.right != null) {
            result = result + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
         }
         return result;
      }



   }
}
