package com.github.chen0040.leetcode.day16.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class CopyListWithRandomPointer {
    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

   public class Solution {
      private Map<Integer, RandomListNode> marked;
      public RandomListNode copyRandomList(RandomListNode head) {
         if(marked == null) {
            marked =new HashMap<Integer, RandomListNode>();
         }
         if(head==null) return null;
         if(marked.containsKey(head.label)) return marked.get(head.label);

         RandomListNode copy = new RandomListNode(head.label);
         marked.put(head.label, copy);
         copy.next = copyRandomList(head.next);
         copy.random = copyRandomList(head.random);
         return copy;
      }
   }
}
