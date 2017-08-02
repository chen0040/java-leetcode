package com.github.chen0040.leetcode.day7.easy;


import java.util.Stack;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * link: https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class ImplementQueueUsingStacks {
   public class MyQueue {

      private Stack<Integer> stack1;
      private Stack<Integer> stack2;
      /** Initialize your data structure here. */
      public MyQueue() {
         stack1 = new Stack<Integer>();
         stack2 = new Stack<Integer>();
      }

      /** Push element x to the back of queue. */
      public void push(int x) {

         stack1.push(x);
      }

      /** Removes the element from in front of queue and returns that element. */
      public int pop() {
         if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
            }
         }
         int value = stack2.pop();

         return value;
      }

      /** Get the front element. */
      public int peek() {
         if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
            }
         }
         return stack2.peek();
      }

      /** Returns whether the queue is empty. */
      public boolean empty() {
         return stack1.isEmpty() && stack2.isEmpty();
      }
   }

   /**
    * Your MyQueue object will be instantiated and called as such:
    * MyQueue obj = new MyQueue();
    * obj.push(x);
    * int param_2 = obj.pop();
    * int param_3 = obj.peek();
    * boolean param_4 = obj.empty();
    */
}
