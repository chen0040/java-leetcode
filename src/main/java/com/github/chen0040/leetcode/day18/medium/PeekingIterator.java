package com.github.chen0040.leetcode.day18.medium;


import java.util.Iterator;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/peeking-iterator/description/
 */
class PeekingIterator implements Iterator<Integer> {

   private Iterator<Integer> iterator;
   private int currentValue;
   private boolean hasNext;

   public PeekingIterator(Iterator<Integer> iterator) {
      // initialize any member here.
      this.iterator = iterator;
      hasNext = iterator.hasNext();
      if(hasNext) {
         currentValue = iterator.next();
      }
   }

   // Returns the next element in the iteration without advancing the iterator.
   public Integer peek() {
      return currentValue;
   }

   // hasNext() and next() should behave the same as in the Iterator interface.
   // Override them if needed.
   @Override
   public Integer next() {
      int value = currentValue;
      this.hasNext = iterator.hasNext();
      if(this.hasNext) {
         currentValue = iterator.next();
      }
      return value;
   }

   @Override
   public boolean hasNext() {
      boolean value = this.hasNext;
      return value;
   }
}
