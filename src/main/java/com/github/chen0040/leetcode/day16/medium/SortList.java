package com.github.chen0040.leetcode.day16.medium;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/sort-list/description/
 */
public class SortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode sortList(ListNode head) {

         if(head == null) return null;
         if(head.next == null) return head;

         ListNode slow = head;
         ListNode fast = head;

         ListNode head2 = null;
         ListNode x = null;
         while(fast != null) {

            ListNode old = x;
            x = new ListNode(slow.val);
            if(old != null) old.next = x;
            if(head2 == null)  head2 = x;

            slow = slow.next;
            if(fast.next != null) {
               fast = fast.next.next;
            } else {
               fast = null;
            }
         }

         ListNode mid = slow;
         head = sortList(head2);
         mid = sortList(mid);


         return merge(head, mid);
      }

      private ListNode merge(ListNode x1, ListNode x2) {
         ListNode x = null;
         ListNode head = null;

         while(x1 != null || x2 != null) {
            ListNode old = x;
            ListNode selected = null;
            if(x1 == null) {
               selected = x2;
               x2 = x2.next;
            }
            else if(x2 == null) {
               selected = x1;
               x1 = x1.next;
            }
            else if(x1.val < x2.val) {
               selected = x1;
               x1 = x1.next;
            }
            else {
               selected = x2;
               x2 = x2.next;
            }

            x = new ListNode(selected.val);
            if(old != null) old.next = x;
            if(head == null) head = x;
         }


         return head;
      }
   }
}
