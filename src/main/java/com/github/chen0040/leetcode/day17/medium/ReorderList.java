package com.github.chen0040.leetcode.day17.medium;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public void reorderList(ListNode head) {
         if(head == null || head.next == null) return;

         ListNode slow = head;
         ListNode fast = head;

         ListNode prev_slow = null;
         while(fast != null) {
            prev_slow = slow;
            slow = slow.next;

            if(fast.next != null) { // odd
               fast = fast.next.next;
            } else { // even
               fast = null;
            }
         }

         prev_slow.next = null;

         ListNode last = reverseList(slow);

         ListNode x = head;
         while(last != null) {
            ListNode x_next = x.next;
            ListNode last_next = last.next;
            x.next = last;
            last.next = x_next;
            x = x_next;
            last = last_next;
         }




      }

      private ListNode reverseList(ListNode head) {
         ListNode x = head;
         ListNode prev = null;
         while(x != null) {
            ListNode x_next = x.next;

            x.next = prev;

            prev = x;
            x = x_next;
         }

         return prev;
      }
   }
}
