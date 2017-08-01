package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * link: https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {
   public class Solution {
      public void merge(int[] nums1, int m, int[] nums2, int n) {
         int N = m + n;
         int i = m-1;
         int j = n-1;
         for(int k=N-1; k >= 0; --k) {
            if(i < 0) {
               nums1[k] = nums2[j--];
            }
            else if(j < 0) {
               nums1[k] = nums1[i--];
            }
            else if(nums1[i] > nums2[j]) {
               nums1[k] = nums1[i--];
            }
            else {
               nums1[k] = nums2[j--];
            }
         }
      }
   }
}
