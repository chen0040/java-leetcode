package com.github.chen0040.leetcode.day17.medium;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode partition(ListNode head, int x) {
         ListNode lo_head = null;
         ListNode hi_head = null;
         ListNode lo = null;
         ListNode hi = null;
         ListNode node = head;
         while(node != null) {
            int val = node.val;
            if(val < x) {
               ListNode old = lo;
               lo = new ListNode(val);
               if(old != null) old.next =lo;
               if(lo_head == null) lo_head = lo;
            } else {
               ListNode old = hi;
               hi = new ListNode(val);
               if(old != null) old.next = hi;
               if(hi_head == null) hi_head = hi;
            }
            node = node.next;
         }

         if(lo != null) {
            lo.next = hi_head;
            return lo_head;
         } else {
            return hi_head;
         }
      }
   }
}
