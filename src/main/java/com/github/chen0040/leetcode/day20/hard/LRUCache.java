package com.github.chen0040.leetcode.day20.hard;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 15/8/2017.
 *
 * link: https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {

   static class IndexedMinPQ {
      private Map<Integer, Long> values = new HashMap<Integer, Long>();
      private Map<Integer, Integer> pq = new HashMap<Integer, Integer>();
      private Map<Integer, Integer> qp = new HashMap<Integer, Integer>();
      private int N = 0;

      public void add(int key, long value) {
         values.put(key, value);
         pq.put(++N, key);
         qp.put(key, N);
         swim(N);
      }

      public int size() {
         return N;
      }

      public boolean containsKey(int key) {
         return values.containsKey(key);
      }

      public void increaseKeyValue(int key, long newValue) {
         values.put(key, newValue);
         int position = qp.get(key);
         sink(position);
      }

      public int delMin() {
         int key = pq.get(1);
         exchange(1, N);
         N--;
         sink(1);
         values.remove(key);
         return key;
      }

      private void swim(int k) {
         while(k > 1) {
            int parent = k / 2;
            if(less(k, parent)) {
               exchange(k, parent);
               k = parent;
            } else {
               break;
            }
         }
      }

      private void sink(int k) {
         while(k * 2 <= N) {
            int child = k * 2;
            if(child < N && less(child+1, child)) {
               child++;
            }
            if(less(child, k)) {
               exchange(child, k);
               k = child;
            } else {
               break;
            }
         }
      }

      private void exchange(int i, int j) {
         int temp = pq.get(i);
         pq.put(i, pq.get(j));
         pq.put(j, temp);

         qp.put(pq.get(i), i);
         qp.put(pq.get(j), j);
      }

      private boolean less(int i, int j) {
         long value_i = values.get(pq.get(i));
         long value_j = values.get(pq.get(j));
         return value_i < value_j;
      }
   }

   private int capacity;
   private IndexedMinPQ counter = new IndexedMinPQ();
   private Map<Integer, Integer> data = new HashMap<Integer, Integer>();
   private long count = 0;
   public LRUCache(int capacity) {
      this.capacity = capacity;
   }

   public int get(int key) {
      if(!counter.containsKey(key)){
         data.remove(key);
         return -1;
      }
      if(data.containsKey(key)){
         counter.increaseKeyValue(key, ++count);
         return data.get(key);
      } else {
         return -1;
      }
   }

   public void put(int key, int value) {
      if(counter.containsKey(key)){
         counter.increaseKeyValue(key, ++count);

      } else {
         counter.add(key, ++count);
         if(counter.size() > capacity) {
            int delKey = counter.delMin();
            data.remove(delKey);
         }
      }

      data.put(key, value);

   }
}

