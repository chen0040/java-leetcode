package com.github.chen0040.leetcode.day16.medium;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/insertion-sort-list/description/
 */
public class InsertionSortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

   public class Solution {
      public ListNode insertionSortList(ListNode head) {
         ListNode head2 = null;
         ListNode tail2 = null;
         for(ListNode i = head; i != null; i = i.next) {
            if(i == head) {
               head2 = new ListNode(i.val);
               tail2 = head2;
            } else {
               ListNode x = head2;
               ListNode prev = null;
               boolean inserted = false;
               while(x != null) {
                  if(x.val <= i.val) {
                     prev = x;
                     x = x.next;
                  } else {

                     ListNode x2 = new ListNode(i.val);
                     if(prev != null) prev.next = x2;
                     else head2 = x2;
                     x2.next = x;
                     inserted = true;
                     break;

                  }
               }

               if(!inserted) {
                  ListNode old = tail2;
                  tail2 = new ListNode(i.val);
                  old.next = tail2;
               }

            }
         }

         return head2;
      }
   }
}
