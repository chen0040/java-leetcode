package com.github.chen0040.leetcode.day05.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * link: https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
   public class Solution {
      private void quickSort(String[] a, int lo, int hi) {
         if(lo >= hi) return;
         int j = partition(a, lo, hi);
         quickSort(a, lo, j-1);
         quickSort(a, j+1, hi);
      }

      private int partition(String[] a, int lo, int hi) {
         int i = lo, j = hi+1;
         String v = a[lo];
         while(true) {
            while(v.length() > a[++i].length()) {
               if(i >= hi) break;
            }
            while(v.length() < a[--j].length()) {
               if(j <= lo) break;
            }
            if(i >= j) break;
            exchange(a, i, j);
         }
         exchange(a, lo, j);
         return j;
      }

      private void exchange(String[] a, int i, int j) {
         String temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }

      public String longestCommonPrefix(String[] strs) {
         if(strs.length == 0) return "";
         if(strs.length == 1) return strs[0];

         quickSort(strs, 0, strs.length-1);
         String a = strs[0];
         int N = a.length();
         int K = -1;
         for(int k = 0; k < N; ++k) {
            boolean valid = true;
            for(int j=1; j < strs.length; ++j) {
               if(a.charAt(k) != strs[j].charAt(k)) {
                  valid = false;
                  break;
               }
            }
            if(valid == false) {
               break;
            } else {
               K = k;
            }
         }
         if(K == -1) return "";
         return a.substring(0, K+1);
      }


   }
}
