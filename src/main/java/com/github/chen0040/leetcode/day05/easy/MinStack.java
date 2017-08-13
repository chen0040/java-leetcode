package com.github.chen0040.leetcode.day05.easy;


import java.util.Stack;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * link: https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {
   private static class Node {
      int val;
      int minVal;
   }

   public class Solution {



      private Stack<Node> stack;
      /** initialize your data structure here. */
      public Solution() {
         stack = new Stack<Node>();
      }

      public void push(int x) {
         int minVal = x;
         if(!stack.isEmpty()){
            Node last = stack.peek();
            minVal = last.minVal;
            if(x < minVal) {
               minVal = x;
            }
         }

         Node newLast = new Node();
         newLast.val = x;
         newLast.minVal = minVal;
         stack.push(newLast);
      }

      public void pop() {
         stack.pop();
      }

      public int top() {
         return stack.peek().val;
      }

      public int getMin() {
         return stack.peek().minVal;
      }
   }

}
