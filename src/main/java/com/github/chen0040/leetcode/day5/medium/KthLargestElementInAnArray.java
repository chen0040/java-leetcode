package com.github.chen0040.leetcode.day5.medium;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementInAnArray {
   public class Solution {
      private void select(int[] a, int lo, int hi, int k) {
         if(lo >= hi) return;
         int j = partition(a, lo, hi);
         if(j == k) {
            return;
         }
         select(a, lo, j-1, k);
         select(a, j+1, hi, k);
      }
      private int partition(int[] a, int lo, int hi) {
         int i = lo, j = hi+1;
         int v = a[lo];
         while(true) {
            while(v < a[++i]) {
               if(i >= hi) break;
            }
            while(v > a[--j]) {
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

      public int findKthLargest(int[] nums, int k) {
         if(nums.length == 0) return -1;
         if(nums.length == 1) {
            return k == 1 ? nums[0] : -1;
         }
         if(nums.length < k) {
            return -1;
         }
         int J = -1;
         int lo = 0;
         int hi = nums.length - 1;

         select(nums, lo, hi, k-1);

         return nums[k-1];
      }
   }
}
