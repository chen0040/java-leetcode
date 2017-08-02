package com.github.chen0040.leetcode.day7.easy;


import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * link: https://leetcode.com/problems/implement-stack-using-queues/description/
 */
public class ImpementStackUsingQueues {
   public class MyStack {

      private Queue<Integer> queue;
      private Queue<Integer> queue2;
      /** Initialize your data structure here. */
      public MyStack() {
         queue = new LinkedList<Integer>();
         queue2 = new LinkedList<Integer>();
      }

      /** Push element x onto stack. */
      public void push(int x) {
         queue.add(x);
      }

      /** Removes the element on top of the stack and returns that element. */
      public int pop() {
         int val = -1;
         while(!queue.isEmpty()){
            val = queue.remove();
            if(!queue.isEmpty()) {
               queue2.add(val);
            }
         }
         Queue<Integer> temp = queue;
         queue = queue2;
         queue2 = temp;
         return val;
      }

      /** Get the top element. */
      public int top() {
         int val = -1;
         while(!queue.isEmpty()){
            val = queue.remove();
            queue2.add(val);
         }
         Queue<Integer> temp = queue;
         queue = queue2;
         queue2 = temp;
         return val;
      }

      /** Returns whether the stack is empty. */
      public boolean empty() {
         return queue.isEmpty();
      }
   }
}
