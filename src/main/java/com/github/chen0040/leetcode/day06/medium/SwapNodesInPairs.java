package com.github.chen0040.leetcode.day06.medium;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode swapPairs(ListNode head) {
         int index = 0;
         ListNode prev = null;
         ListNode x = head;
         while(x != null) {
            ListNode x_next = x.next;

            if(index  % 2 == 1) {
               ListNode x1 = prev;
               ListNode x2 = x;

               if(x_next != null){
                  if(x_next.next != null) {
                     x1.next = x_next.next;
                  } else {
                     x1.next = x_next;
                  }
               }
               else x1.next = null;

               x2.next = x1;

               if(index == 1) {
                  head = x2;
               }
            }

            prev = x;

            x = x_next;
            index++;
         }

         return head;
      }
   }
}
