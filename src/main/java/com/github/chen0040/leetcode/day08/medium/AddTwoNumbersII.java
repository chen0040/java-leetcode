package com.github.chen0040.leetcode.day08.medium;


/**
 * Created by xschen on 3/8/2017.
 *
 * summary:
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * link: https://leetcode.com/problems/add-two-numbers-ii/description/
 */
public class AddTwoNumbersII {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {

      public ListNode addTwoNumbers(ListNode a, ListNode b) {
         if(a == null) return b;
         if(b == null) return a;
         if(isZero(b)) {
            return trim(a);
         }
         ListNode carry = computeCarry(a, b);
         a = computeRemainder(a, b);
         return addTwoNumbers(a, carry);
      }

      ListNode trim(ListNode a) {
         while(a != null && a.val == 0) {
            a = a.next;
         }
         if(a == null){
            return new ListNode(0);
         }
         return a;
      }

      boolean isZero(ListNode b) {
         while(b !=null) {
            if(b.val != 0) {
               return false;
            }
            b = b.next;
         }
         return true;
      }

      ListNode computeCarry(ListNode a, ListNode b) {
         a = reverse(a);
         b = reverse(b);
         ListNode head = null;
         ListNode old = null;
         int val3 = 0;
         while(a != null || b != null) {
            int val1 = a != null ? a.val : 0;
            int val2 = b != null ? b.val : 0;
            val3 = (val1 + val2) / 10;

            old = head;
            head = new ListNode(val3);
            head.next = old;

            if(a != null) a = a.next;
            if(b != null) b = b.next;
         }

         ListNode x = head;
         while(x != null) {
            if(x.next == null){
               x.next = new ListNode(0);
               break;
            }
            x = x.next;
         }

         return head;
      }

      ListNode computeRemainder(ListNode a, ListNode b) {
         a = reverse(a);
         b = reverse(b);
         ListNode head = null;
         while(a != null || b != null) {
            int val1 = a != null ? a.val : 0;
            int val2 = b != null ? b.val : 0;


            int val3 = (val1 + val2) % 10;

            ListNode old = head;
            head = new ListNode(val3);
            head.next = old;

            if(a != null) a = a.next;
            if(b != null) b = b.next;
         }

         return head;
      }

      ListNode reverse(ListNode a) {
         ListNode x = a;
         ListNode head = null;
         while(x != null) {

            ListNode old = head;
            head = new ListNode(x.val);
            head.next = old;
            x = x.next;
         }
         return head;
      }
   }
}
