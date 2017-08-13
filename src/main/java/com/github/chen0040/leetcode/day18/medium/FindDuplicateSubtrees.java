package com.github.chen0040.leetcode.day18.medium;


import java.util.*;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/find-duplicate-subtrees/description/
 */
public class FindDuplicateSubtrees {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Solution {
      Map<String, TreeNode> repeated;
      Set<String> signatures;
      public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         repeated = new HashMap<String, TreeNode>();
         signatures = new HashSet<String>();
         preorder(root);
         return new ArrayList<TreeNode>(repeated.values());
      }

      private String preorder(TreeNode x) {
         if(x == null) {
            return "#";
         }

         String prefix = "";
         if(x.left == null && x.right == null) {
            prefix = "" + x.val;
         } else {
            prefix = append(prefix, "" + x.val);
            prefix = append(prefix, preorder(x.left));
            prefix = append(prefix, preorder(x.right));
         }

         //System.out.println(prefix);
         if(signatures.contains(prefix)) {
            repeated.put(prefix, x);
         }
         signatures.add(prefix);

         return prefix;
      }

      private String append(String prefix, String val) {
         if(prefix.equals("")) {
            prefix = val;
         } else {
            prefix = prefix + "," + val;
         }

         return prefix;
      }
   }
}
