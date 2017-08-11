package com.github.chen0040.leetcode.day16.medium;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class FlattenNestedListIterator {
    public interface NestedInteger {

             // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();

             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
             public Integer getInteger();

             // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return null if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
  }

   public class NestedIterator implements Iterator<Integer> {

      private Stack<NestedInteger> stack;

      public NestedIterator(List<NestedInteger> nestedList) {
         stack = new Stack<NestedInteger>();
         for(int i=nestedList.size()-1; i >= 0; --i) {
            stack.push(nestedList.get(i));
         }
      }

      @Override
      public Integer next() {
         NestedInteger ni = stack.pop();
         if(ni.isInteger()) {
            return ni.getInteger();
         } else {
            while(!ni.isInteger()){
               List<NestedInteger> nestedList = ni.getList();
               for(int i=nestedList.size()-1; i >= 0; --i) {
                  stack.push(nestedList.get(i));
               }
               ni = stack.pop();
            }

            return ni.getInteger();

         }
      }

      @Override
      public boolean hasNext() {
         if(stack.isEmpty()) return false;
         NestedInteger ni = stack.peek();
         if(ni.isInteger()) {
            return true;
         } else {
            while(!ni.isInteger()){
               stack.pop();
               List<NestedInteger> nestedList = ni.getList();
               for(int i=nestedList.size()-1; i >= 0; --i) {
                  stack.push(nestedList.get(i));
               }
               if(stack.isEmpty()) return false;
               ni = stack.peek();
            }
            return true;
         }
      }
   }
}
