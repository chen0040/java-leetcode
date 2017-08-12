package com.github.chen0040.leetcode.day17.medium;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public ListNode oddEvenList(ListNode head) {
         if(head == null || head.next == null) return head;
         ListNode odd_head = null;
         ListNode even_head = null;
         ListNode odd = null;
         ListNode even = null;

         ListNode node = head;
         boolean is_odd = true;
         while(node != null) {
            ListNode node_next = node.next;

            if(is_odd) {
               ListNode old = odd;
               odd = node;
               odd.next = null;
               if(old != null) old.next = odd;
               if(odd_head == null) odd_head = odd;

               is_odd = false;
            } else {
               ListNode old = even;
               even = node;
               even.next = null;
               if(old != null) old.next = even;
               if(even_head == null) even_head = even;

               is_odd = true;
            }

            node = node_next;
         }

         if(odd != null) {
            odd.next = even_head;
            return odd_head;
         } else {
            return even_head;
         }
      }
   }
}
