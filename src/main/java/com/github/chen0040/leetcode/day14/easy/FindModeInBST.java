package com.github.chen0040.leetcode.day14.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 */
public class FindModeInBST {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public class Solution {
      public int[] findMode(TreeNode root) {
         Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
         collect(root, freq);
         int maxCount = 0;
         for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int count = entry.getValue();
            maxCount = Math.max(count, maxCount);
         }
         List<Integer> list = new ArrayList<Integer>();
         for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            if(count == maxCount) {
               list.add(entry.getKey());
            }
         }
         int[] result =new int[list.size()];
         int index = 0;
         for(Integer i : list) {
            result[index++] = i;
         }
         return result;
      }

      private void collect(TreeNode x, Map<Integer, Integer> freq) {
         if(x == null) {
            return;
         }

         collect(x.left, freq);

         freq.put(x.val, freq.getOrDefault(x.val, 0) + 1);

         collect(x.right, freq);
      }
   }
}
