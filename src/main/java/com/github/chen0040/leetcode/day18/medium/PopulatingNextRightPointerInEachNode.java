package com.github.chen0040.leetcode.day18.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 */
public class PopulatingNextRightPointerInEachNode {
    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

   public class Solution {
      Map<Integer, TreeLinkNode> levels = new HashMap<Integer, TreeLinkNode>();
      public void connect(TreeLinkNode root) {
         connect(root, 0);
      }

      private void connect(TreeLinkNode x, int d) {
         if(x == null) {
            return;
         }

         connect(x.left, d+1);

         if(levels.containsKey(d)) {
            levels.get(d).next = x;
            levels.put(d, x);
         } else {
            levels.put(d, x);
         }

         connect(x.right, d+1);
      }
   }
}
