package com.github.chen0040.leetcode.day07.easy;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given a singly linked list, determine if it is a palindrome.
 *
 * link: https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PanlindromeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   public class Solution {
      public boolean isPalindrome(ListNode head) {
         ListNode x = head;
         ListNode head2 = null;
         while(x != null) {
            ListNode old = head2;
            head2 = new ListNode(x.val);
            head2.next = old;

            x = x.next;
         }

         x = head;
         ListNode x2 = head2;
         while(x != null) {
            if(x.val != x2.val) {
               return false;
            }
            x = x.next;
            x2 = x2.next;
         }
         return true;
      }
   }
}
