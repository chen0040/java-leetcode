package com.github.chen0040.leetcode.day05.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a linked list, determine if it has a cycle in it.
 *
 * link: https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

   public class Solution {
      public boolean hasCycle(ListNode head) {

         ListNode x = head;
         ListNode x2 = head;
         while(x != null && x2 != null) {
            x = x.next;

            x2 = x2.next;
            if(x2 != null) {
               x2 = x2.next;
            } else {
               return false;
            }

            if(x == x2) {
               return true;
            }
         }
         return false;
      }
   }
}
