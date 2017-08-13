package com.github.chen0040.leetcode.day18.medium;


import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 */
public class SerializeAndDeserializeBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public class Codec {

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.add(root);
         boolean first = true;
         while(!queue.isEmpty()) {
            TreeNode x = queue.remove();
            if(first){
               first = false;
            } else {
               sb.append(",");
            }
            if(x == null){
               sb.append("#");
            } else {
               sb.append(x.val);
               queue.add(x.left);
               queue.add(x.right);
            }
         }
         return sb.toString();
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
         String[] values = data.split(",");
         Queue<TreeNode> queue = new LinkedList<TreeNode>();

         int count = 0;
         TreeNode root = create(values, count++);
         queue.add(root);
         while(count < values.length) {
            TreeNode x = queue.remove();
            x.left = create(values, count++);
            x.right = create(values, count++);

            if(x.left != null) {
               queue.add(x.left);
            }
            if(x.right != null) {
               queue.add(x.right);
            }
         }
         return root;
      }

      private TreeNode create(String[] values, int count) {
         if(values[count].equals("#")) {
            return null;
         }
         return new TreeNode(Integer.parseInt(values[count]));
      }


   }
}
