package com.github.chen0040.leetcode.day5.medium;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode point = head;
         ListNode point_n = null;
         ListNode prev_n = null;
         int index = 0;
         while(point != null) {
            if(index+1 == n) {
               point_n = head;
            }

            if(point.next == null) {
               break;
            }

            point = point.next;

            prev_n = point_n;
            if(point_n != null) point_n = point_n.next;

            index++;
         }

         if(point_n != null) {
            if(prev_n == null) {
               return point_n.next;
            } else if(prev_n != null) {
               prev_n.next = point_n.next;
            }
         }


         return head;

      }
   }
}
