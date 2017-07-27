package com.github.chen0040.leetcode.day1.easy;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * link: https://leetcode.com/problems/array-partition-i/tabs/description
 */
public class ArrayPartitionI
{
   public void quickSort(int[] a) {
      quickSort(a, 0, a.length - 1);
   }

   public void quickSort(int[] a, int lo, int hi) {
      if(lo >= hi) return;
      int j = partition(a, lo, hi);
      quickSort(a, lo, j-1);
      quickSort(a, j+1, hi);
   }

   public int partition(int[] a, int lo, int hi) {
      int i=lo, j=hi+1;
      int v = a[lo];
      while(true) {
         while(v > a[++i]){
            if(i == hi) break;
         }
         while(v < a[--j]) {
            if(j == lo) break;
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

   public int arrayPairSum(int[] nums) {
      quickSort(nums);
      int sum = 0;
      for(int i=0; i < nums.length; i+=2) {
         sum += nums[i];
      }
      return sum;
   }
}
