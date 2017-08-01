package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * link: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class IntersectionOfTwoLinkedLists {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }

  public static void main(String[] args) {
        ListNode headA = buildLinkedList(1, 2);
        ListNode headB = buildLinkedList(4, 5, 6);
        ListNode headC = buildLinkedList(7, 8, 9);

        join(headA, headC);
        join(headB, headC);

        Solution solution =new Solution();
        ListNode headI = solution.getIntersectionNode(headA,headB);

        if(headI != null) {
           System.out.println("Intersection: " + headI.val);
        } else {
           System.out.println("Intersection: null");
        }
  }

  private static void join(ListNode head1, ListNode head2) {
        ListNode last1 = head1;
        while(last1.next != null) {
           last1 = last1.next;
        }
        last1.next = head2;
  }

  private static ListNode buildLinkedList(int... args) {
        ListNode head = null;
        ListNode prev = null;
        for(int i=0; i < args.length; ++i) {
           ListNode x = new ListNode(args[i]);
           if(prev != null) prev.next = x;
           if(head == null) head = x;
           prev = x;
        }
        return head;
  }

   public static class Solution {
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int aLen = 0;
         int bLen = 0;
         ListNode a = headA;
         ListNode b = headB;
         while(a != null){
            a = a.next;
            aLen++;
         }
         while(b != null) {
            b = b.next;
            bLen++;
         }

         int dLen = 0;
         if(aLen > bLen) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            dLen = aLen - bLen;
         } else {
            dLen = bLen - aLen;
         }

         int index = 0;

         b = headB;
         a = null;
         while(b != null) {
            if(index == dLen){
               a = headA;
            }

            if(a == b) {
               return a;
            }

            if(a != null) a = a.next;
            b = b.next;
            index++;
         }

         return null;


      }
   }
}
