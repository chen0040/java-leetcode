package com.github.chen0040.leetcode.day12.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 7/8/2017.
 *
 * link: https://leetcode.com/problems/print-binary-tree/description/
 */
public class PrintBinaryTree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      public List<List<String>> printTree(TreeNode root) {
         int depth = depth(root);
         int colCount = (1 << depth) - 1;
         String[][] res = new String[depth][colCount];
         print(root, res, 0, 0, colCount-1);
         List<List<String>> result = new ArrayList<List<String>>();
         for(int i=0; i < depth; ++i) {
            List<String> list =new ArrayList<String>();
            for(int j=0; j < colCount; ++j) {
               String val = res[i][j] == null ? "" : res[i][j];
               list.add(val);
            }
            result.add(list);
         }
         return result;
      }

      private void print(TreeNode x, String[][] res, int d, int left, int right) {
         if(x == null) {
            return;
         }
         res[d][(left + right) / 2] = "" + x.val;
         print(x.left, res, d+1, left, (right+left) / 2);
         print(x.right, res, d+1, (right+left)/2 + 1, right);
      }

      private int depth(TreeNode x) {
         if(x == null) {
            return 0;
         }
         return 1 + Math.max(depth(x.left), depth(x.right));
      }
   }
}
