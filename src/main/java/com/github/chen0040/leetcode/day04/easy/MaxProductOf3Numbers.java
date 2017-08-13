package com.github.chen0040.leetcode.day04.easy;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * link: https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 */
public class MaxProductOf3Numbers {
   public class Solution {
      private void mergeSort(int[] a) {
         int[] aux = new int[a.length];
         mergeSort(a, aux, 0, a.length-1);
      }

      private void mergeSort(int[] a, int[] aux, int lo, int hi) {
         if(lo >= hi) return;
         int mid = (lo + hi) / 2;
         mergeSort(a, aux, lo, mid);
         mergeSort(a, aux, mid+1, hi);
         merge(a, aux, lo, mid, hi);
      }

      private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
         for(int k = lo; k <= hi; ++k) {
            aux[k] = a[k];
         }
         int i=lo, j=mid+1;
         for(int k = lo; k <= hi; ++k) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(aux[i] > aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
         }
      }

      public int maximumProduct(int[] nums) {
         mergeSort(nums);

         int result = Math.max(nums[0] * nums[1] * nums[2],
                 nums[0] * nums[nums.length-2] * nums[nums.length-1]);

         result = Math.max(result, nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1]);

         return result;
      }
   }
}
