package com.github.chen0040.leetcode.day03.easy;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Reverse a singly linked list.
 *
 * link: https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReversedLinkedList {
 public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode reverseList(ListNode head) {
         ListNode x = head;
         ListNode first = null;
         while(x != null) {
            ListNode x_next = x.next;
            ListNode oldFirst = first;
            first = x;
            first.next = oldFirst;
            x = x_next;
         }
         return first;
      }
   }
}
