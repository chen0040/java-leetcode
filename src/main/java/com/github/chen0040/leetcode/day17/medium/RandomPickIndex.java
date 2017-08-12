package com.github.chen0040.leetcode.day17.medium;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/random-pick-index/description/
 */
public class RandomPickIndex {
   public class Solution {

      private int[] ids;
      private int[] nums;
      private Map<Integer, int[]> bounds;
      private Random random;
      public Solution(int[] nums) {
         random = new Random();

         ids = new int[nums.length];
         this.nums = nums;
         bounds = new HashMap<Integer, int[]>();
         for(int i=0; i < nums.length; ++i) {
            ids[i] = i;
         }
         quickSort(ids, 0, nums.length-1);

         int lo = 0;
         int hi = 0;
         int prev = Integer.MIN_VALUE;
         for(int i=0; i < ids.length; ++i) {
            if(i != 0) {
               if(nums[ids[i]] != prev){
                  hi = i - 1;
                  bounds.put(prev, new int[] { lo, hi });
                  lo = i;
               }
            }
            prev = nums[ids[i]];
         }
         bounds.put(prev, new int[] {lo, ids.length-1});
      }

      private void quickSort(int[] a, int lo, int hi) {
         if(lo >= hi) return;

         int j = partition(a, lo, hi);
         quickSort(a, lo, j-1);
         quickSort(a, j+1, hi);
      }

      private int partition(int[] a, int lo, int hi) {
         int i = lo, j = hi+1;
         int v = a[lo];
         while(true) {
            while(nums[v] > nums[a[++i]]) {
               if(i >= hi) break;
            }
            while(nums[v] < nums[a[--j]]) {
               if(j <= lo) break;
            }

            if(i >= j) break;
            exchange(a, i, j);
         }
         exchange(a, lo, j);
         return j;
      }

      private void exchange(int[] a, int i, int j) {
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }

      public int pick(int target) {
         int[] bound = bounds.get(target);
         int lo = bound[0];
         int hi = bound[1];
         if(lo == hi) return ids[lo];
         return ids[random.nextInt(hi - lo + 1) + lo];
      }
   }
}
