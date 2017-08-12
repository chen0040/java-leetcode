package com.github.chen0040.leetcode.day17.medium;


import java.util.Random;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/linked-list-random-node/description/
 */
public class LinkedListRandomNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {

      private int upper;
      private Random random;
      private ListNode head;

      /** @param head The linked list's head.
      Note that the head is guaranteed to be not null, so it contains at least one node. */
      public Solution(ListNode head) {
         this.head = head;
         random = new Random();
         ListNode x = head;
         ListNode prev = null;
         upper = 0;
         while(x != null) {
            prev = x;
            x = x.next;
            upper++;
         }
         prev.next = head;
      }

      /** Returns a random node's value. */
      public int getRandom() {
         int v = random.nextInt(upper);
         for(int i=0; i < v; ++i) {
            head = head.next;
         }
         return head.val;
      }
   }

}
