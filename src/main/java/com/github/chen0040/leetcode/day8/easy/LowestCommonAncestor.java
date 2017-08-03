package com.github.chen0040.leetcode.day8.easy;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Created by xschen on 3/8/2017.
 *
 * link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonAncestor {
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
        TreeNode root = buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        print(root);
        Solution s = new Solution();
        TreeNode selected = s.lowestCommonAncestor(root, get(root, 4), get(root, 5));
        if(selected != null){
           System.out.println(selected.val);
        }
  }

  private static void print(TreeNode x) {
        print(x, "");
  }

  private static void print(TreeNode x, String prefix) {
        if(x == null) return;
        System.out.println(prefix + x.val);
        print(x.left, prefix + " ");
        print(x.right, prefix + " ");
  }

  private static TreeNode buildTree(Integer... values){
        return buildTree(null, queue(values));
  }

  private static Queue<Integer> queue(Integer... values) {
     Queue<Integer> result = new LinkedList<>();
     for(int i=0; i < values.length; ++i) {
        result.add(values[i]);
     }
     return result;
  }

  private static TreeNode get(TreeNode x, int i) {
     if(x == null){
        return null;
     }
     if(x.val == i) {
        return x;
     }
     TreeNode left = get(x.left, i);
     if(left != null) {
        return left;
     }
     TreeNode right = get(x.right, i);
     if(right != null) {
        return right;
     }
     return null;
  }

  private static TreeNode buildTree(TreeNode x, Queue<Integer> values) {
     if(values.isEmpty()) {
        return x;
     }

     Queue<TreeNode> queue = new LinkedList<>();
     if(x == null) {
        Integer val = values.remove();
        if(val == null){
           return null;
        }
        x = new TreeNode(val);
     }
     queue.add(x);

     while(!queue.isEmpty() && !values.isEmpty()) {
        TreeNode node = queue.remove();
        if(node == null) continue;
        Integer val1 = values.remove();
        if(val1 != null) {
           TreeNode left = new TreeNode(val1);
           node.left = left;
           queue.add(left);
        } else {
           queue.add(null);
        }

        if(values.isEmpty()) break;
        Integer val2 = values.remove();
        if(val2 != null){
           TreeNode right = new TreeNode(val2);
           node.right = right;
           queue.add(right);
        } else {
           queue.add(null);
        }

     }



     return x;
  }

   public static class Solution {
     private TreeNode lowest = null;
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         lowest = null;
         find(root, p, q);

         return lowest;
      }

      private TreeNode[] find(TreeNode x, TreeNode p, TreeNode q) {
         if(x == null) return new TreeNode[] { null, null };
         TreeNode[] found = new TreeNode[2];
         if(x == p) {
            found[0] = p;
         }
         if(x == q) {
            found[1] = q;
         }

         TreeNode[] leftFound = find(x.left, p, q);
         TreeNode[] rightFound = find(x.right, p, q);

         for(int i=0; i < 2; ++i) {
            if(leftFound[0] == p || rightFound[0] == p) found[0] = p;
            if(leftFound[1] == q || rightFound[1] == q) found[1] = q;
         }

         if(found[0] == p && found[1] == q) {
            if(lowest == null) {
               lowest = x;
            }
         }

         return found;
      }


   }
}
