package com.github.chen0040.leetcode.day18.medium;


import java.util.*;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorOfBinaryTree {
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Solution s = new Solution();
        TreeNode node = s.lowestCommonAncestor(root, root, root.left);
        System.out.println(node);
  }

   public static class Solution {
      private Map<TreeNode, TreeNode> id = new HashMap<TreeNode, TreeNode>();
      private List<TreeNode> p_path = new ArrayList<TreeNode>();
      private List<TreeNode> q_path = new ArrayList<TreeNode>();

      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null) return null;

         traverse(root, null, p, q);

         int len = Math.min(p_path.size(),q_path.size());
         for(int i=0; i < len; ++i) {
            if(p_path.get(i) != q_path.get(i) ){
               return p_path.get(i-1);
            }
         }
         return p_path.get(len-1);
      }

      private void traverse(TreeNode x, TreeNode parent, TreeNode p, TreeNode q) {
         if(x == null) return;
         id.put(x, parent);

         if(x == p) {
            System.out.println("p path generated!");
            generate_path(p_path, p);
         }
         if(x == q) {
            System.out.println("q path generated!");
            generate_path(q_path, q);
         }

         if(!p_path.isEmpty() && !q_path.isEmpty()) return;

         traverse(x.left, x, p, q);
         traverse(x.right, x, p, q);
      }

      private void generate_path(List<TreeNode> path, TreeNode target) {
         TreeNode x = target;
         Stack<TreeNode> stack = new Stack<TreeNode>();
         while(x != null) {
            stack.push(x);
            x = id.get(x);
         }
         while(!stack.isEmpty()) {
            path.add(stack.pop());
         }
      }
   }
}
