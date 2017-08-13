package com.github.chen0040.leetcode.day07.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Remove all elements from a linked list of integers that have value val.
 *
 * link: https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class RemoveLinkedListElements {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode removeElements(ListNode head, int val) {
         ListNode prev = null;
         ListNode x = head;
         while(x != null) {
            ListNode x_next = x.next;
            if(x.val == val) {
               if(prev != null) {
                  prev.next = x_next;
               } else {
                  head = x_next;
               }
            } else {
               prev = x;
            }
            x = x_next;
         }

         return head;
      }
   }
}
