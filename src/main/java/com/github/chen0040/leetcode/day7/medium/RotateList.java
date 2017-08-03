package com.github.chen0040.leetcode.day7.medium;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * link: https://leetcode.com/problems/rotate-list/description/
 */
public class RotateList {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode rotateRight(ListNode head, int k) {
         int len = 0;

         ListNode x = head;
         ListNode x2 = null;
         ListNode head2 = null;
         ListNode last = null;
         while(x != null){
            if(x.next == null) {
               last = x;
            }

            ListNode old = x2;
            x2 = new ListNode(x.val);
            if(old != null) old.next = x2;
            if(head2 == null) head2 = x2;

            x = x.next;
            len++;
         }

         if(last == null) return head;

         if(k > len) {
            k = k % len;
         }

         last.next = head2;

         x = head;
         for(int i=0; i < len - k; ++i) {
            x = x.next;
         }

         head = x;

         for(int i=0; i < len - 1; ++i) {
            x = x.next;
         }

         x.next = null;

         return head;


      }
   }
}
