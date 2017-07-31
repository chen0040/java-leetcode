package com.github.chen0040.leetcode.day5.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * link: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedList {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode head = null;
         ListNode x1 = l1;
         ListNode x2 = l2;
         ListNode x3 = null;
         while(x1 != null || x2 != null) {
            ListNode old = x3;
            if(x1 == null) {
               x3 = x2;
               x2 = x2.next;
            } else if(x2 == null) {
               x3 = x1;
               x1 = x1.next;
            } else if(x1.val < x2.val) {
               x3 = x1;
               x1 = x1.next;
            } else {
               x3 = x2;
               x2 = x2.next;
            }
            if(old != null) old.next = x3;
            if(head == null) head = x3;


         }
         return head;
      }
   }
}
