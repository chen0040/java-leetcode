package com.github.chen0040.leetcode.day6.medium;


import com.github.chen0040.leetcode.day6.easy.IntersectionOfTwoLinkedLists;


/**
 * Created by xschen on 1/8/2017.
 * 
 * link: https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class LinkedListCycleII {
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

  public static void main(String[] args) {
        ListNode head = buildLinkedList(1, 2, 3, 4, 5, 6, 7, 8);
        get(head, 8).next = get(head, 4);
        Solution s = new Solution();
        ListNode pt = s.detectCycle(head);

        System.out.println(pt.val);

        head = buildLinkedList(1);

        pt = s.detectCycle(head);

        if(pt == null) {
           System.out.println("correct");
        }
  }

   private static ListNode get(ListNode head1, int val) {
      ListNode last1 = head1;
      while(last1 != null) {
         if(last1.val == val) {
            return last1;
         }
         last1 = last1.next;
      }
      return null;
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
        public ListNode detectCycle(ListNode head) {
           ListNode slow = head;
           ListNode fast = head;

           while (fast!=null && fast.next!=null){
              fast = fast.next.next;
              slow = slow.next;

              if (fast == slow){
                 ListNode slow2 = head;
                 while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                 }
                 return slow;
              }
           }
           return null;
        }
      public ListNode detectCycle2(ListNode head) {
         ListNode x1 = head;
         ListNode x2 = head;
         while(x1 != null && x2 != null) {

            if(x1 != head && x1 == x2) {
               break;
            }

            x1 = x1.next;
            x2 = x2.next;
            if(x2 != null) {
               x2 = x2.next;
            } else {
               break;
            }
         }

         if(x2 == null) {
            return null;
         }

         x2 = head;
         while(x1 != x2) {
            x1 = x1.next;
            x2 = x2.next;
         }

         return x2;
      }
   }
}
