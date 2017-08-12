package com.github.chen0040.leetcode.day17.medium;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertSortedListToBinaryTree {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }



     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

   public class Solution {
      public TreeNode sortedListToBST(ListNode head) {
         if(head == null) return null;
         if(head.next == null) return new TreeNode(head.val);

         ListNode head2 = null;
         ListNode x2 = null;
         ListNode prev2 = null;

         ListNode slow = head;
         ListNode fast = head;
         ListNode prev = null;
         int mid = -1;

         boolean odd_number = false;
         while(fast != null) {

            prev2 = x2;
            x2 = new ListNode(slow.val);
            if(prev2!=null) prev2.next = x2;
            if(head2 == null) head2 = x2;

            prev = slow;
            slow = slow.next;

            if(fast.next != null) {
               fast = fast.next.next;
            } else { // odd number of nodes
               odd_number = true;
               fast = null;
            }
         }

         ListNode left = null;
         if(!odd_number) {
            left = head2 == x2 ? null : head2;
         } else {
            left = head2;
         }

         if(prev2 != null) prev2.next = null;
         ListNode right = slow;
         mid = x2.val;

         TreeNode root = new TreeNode(mid);

         root.left = sortedListToBST(left);
         root.right = sortedListToBST(right);

         return root;



      }
   }
}
