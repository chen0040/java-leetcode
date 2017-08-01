package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesFromSortedList {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode deleteDuplicates(ListNode head) {
         ListNode x = head;
         while(x != null) {
            ListNode x_next = x.next;
            while(x_next != null && x.val == x_next.val) {
               x_next = x_next.next;
            }
            x.next = x_next;
            x = x_next;
         }
         return head;
      }
   }
}
