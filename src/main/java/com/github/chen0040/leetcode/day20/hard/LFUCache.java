package com.github.chen0040.leetcode.day20.hard;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 15/8/2017.
 *
 * link: https://leetcode.com/problems/lfu-cache/description/
 */
public class LFUCache {

   static class IndexedMinPQ<Val> {
      private Map<Integer, Val> values = new HashMap<Integer, Val>();
      private Map<Integer, Integer> pq = new HashMap<Integer, Integer>();
      private Map<Integer, Integer> qp = new HashMap<Integer, Integer>();
      private int N = 0;
      private Comparator<Val> comparator;

      public IndexedMinPQ(Comparator<Val> comparator) {
         this.comparator = comparator;
      }

      public void add(int key, Val value) {
         values.put(key, value);
         pq.put(++N, key);
         qp.put(key, N);
         swim(N);
      }

      public int size() {
         return N;
      }

      public Val get(int key) {
         return values.get(key);
      }

      public int minKey() {
         return pq.get(1);
      }

      public boolean containsKey(int key) {
         return values.containsKey(key);
      }

      public void increaseKeyValue(int key, Val newValue) {
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
         Val value_i = values.get(pq.get(i));
         Val value_j = values.get(pq.get(j));
         return comparator.compare(value_i, value_j) < 0;
      }
   }

   private int capacity;
   private IndexedMinPQ<long[]> counter;
   private Map<Integer, Integer> data = new HashMap<Integer, Integer>();
   private long count = 0;
   public LFUCache(int capacity) {
      this.capacity = capacity;
      counter = new IndexedMinPQ<long[]>((a, b) -> {
         if(a[0] == b[0]) {
            return Long.compare(a[1], b[1]);
         } else {
            return Long.compare(a[0], b[0]);
         }
      });
   }

   public int get(int key) {
      if(capacity == 0) return -1;
      if(!counter.containsKey(key)){
         data.remove(key);
         return -1;
      }
      if(data.containsKey(key)){
         long[] values = counter.get(key);
         values[0]++;
         values[1] = ++count;
         counter.increaseKeyValue(key, values);
         return data.get(key);
      } else {
         return -1;
      }
   }

   public void put(int key, int value) {
      if(capacity == 0) return;
      if(counter.containsKey(key)){
         long[] values = counter.get(key);
         values[0]++;
         values[1] = ++count;
         counter.increaseKeyValue(key, values);

      } else {
         long frequency = 0L;
         if(counter.size()+1 > capacity) {
            int delKey = counter.delMin();
            data.remove(delKey);
                 /*
                if(counter.size() > 0) {
                    frequency = Math.max(frequency, counter.get(counter.minKey())[0]);
                }*/
         }

         counter.add(key, new long[] { frequency + 1, ++count });

      }

      data.put(key, value);

   }
}
