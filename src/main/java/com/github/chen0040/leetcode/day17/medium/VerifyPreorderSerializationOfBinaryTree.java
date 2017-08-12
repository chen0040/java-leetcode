package com.github.chen0040.leetcode.day17.medium;


import java.util.Stack;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 */
public class VerifyPreorderSerializationOfBinaryTree {
   public class Solution {
      public boolean isValidSerialization(String preorder) {
         Stack<String> stack = new Stack<String>();
         String[] a = preorder.split(",");
         for(int i=0; i < a.length; ++i) {
            String node = a[i];
            if(node.equals("#")) {
               while(!stack.isEmpty() && stack.peek().equals("#")) {
                  stack.pop();
                  if(stack.isEmpty()) {
                     return false;
                  }
                  stack.pop();
               }
               stack.push("#");
            } else {
               stack.push(node);
            }
         }

         return stack.size() == 1 && stack.peek().equals("#");
      }
   }
}
