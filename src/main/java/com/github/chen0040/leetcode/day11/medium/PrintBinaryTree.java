package com.github.chen0040.leetcode.day11.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 6/8/2017.
 *
 *
 */
public class PrintBinaryTree {



  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
      Solution s  = new Solution();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);

      List<List<String>> result = s.printTree(root);

      for(int i=0; i < result.size(); ++i) {
         for(int j=0; j < result.get(i).size(); ++j) {
            System.out.print(" \"" + result.get(i).get(j) + "\"");
         }
         System.out.println();
      }
  }

   public static class Solution {
      private Map<Integer, Map<Integer, Integer>> states;
      public List<List<String>> printTree(TreeNode root) {
         states = new HashMap<Integer, Map<Integer, Integer>>();
         int depth = print(root, 0, 0);
         List<List<String>> result = new ArrayList<List<String>>();
         int rowLen = 0;

         for(int i=0; i < depth; ++i) {
            rowLen += 1 << i;
         }
         for(int i=0; i < depth; ++i) {
            Map<Integer, Integer> list = states.getOrDefault(i, new HashMap<Integer, Integer>());
            List<String> list2 = new ArrayList<String>();
            for(int j=0; j < rowLen; ++j) {

               int pos = j - (rowLen)/ 2;
               if(list.containsKey(pos)) {
                  list2.add("" + list.get(pos));
               } else {
                  list2.add("");
               }
            }
            result.add(list2);
         }
         return result;
      }

      private int print(TreeNode x, int d, int pos) {
         if(x == null) {
            return d;
         }

         int depth_l = print(x.left, d+1, pos-1);

         Map<Integer, Integer> list = null;
         if(states.containsKey(d)){
            list = states.get(d);
         } else {
            list = new HashMap<Integer, Integer>();
            states.put(d, list);
         }

         list.put(pos, x.val);

         int depth_r = print(x.right, d+1, pos+1);

         return Math.max(depth_l, depth_r);
      }


   }
}
