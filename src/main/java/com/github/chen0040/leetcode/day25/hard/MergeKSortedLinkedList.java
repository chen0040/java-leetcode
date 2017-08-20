package com.github.chen0040.leetcode.day25.hard;


import java.util.PriorityQueue;


/**
 * Created by xschen on 20/8/2017.
 *
 * link: https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   class Solution {
      public ListNode mergeKLists(ListNode[] lists) {
         PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> {
            return Integer.compare(a.val, b.val);
         });
         for(ListNode node : lists) {
            if(node != null)
               pq.add(node);
         }
         ListNode head = null;
         ListNode x = null;
         while(!pq.isEmpty()){
            ListNode node = pq.poll();
            ListNode old = x;
            x = new ListNode(node.val);
            if(old != null) old.next = x;
            if(head == null) head = x;
            node = node.next;
            if(node != null) {
               pq.add(node);
            }
         }
         return head;
      }
   }
}
