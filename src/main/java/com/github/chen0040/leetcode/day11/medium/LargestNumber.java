package com.github.chen0040.leetcode.day11.medium;


/**
 * Created by xschen on 6/8/2017.
 *
 * summary:
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * link: https://leetcode.com/problems/largest-number/description/
 */
public class LargestNumber {
   public class Solution {
      private void quickSort(int[] nums, int lo, int hi) {
         if(lo >= hi) return;
         int j = partition(nums, lo, hi);
         quickSort(nums, lo, j-1);
         quickSort(nums, j+1, hi);
      }

      private int partition(int[] nums, int lo, int hi) {
         int i = lo, j = hi + 1;
         int v = nums[lo];
         while(true) {
            while(less(v, nums[++i])) {
               if(i >= hi) break;
            }
            while(less(nums[--j], v)) {
               if(j <= lo) break;
            }
            if(i >= j) break;
            exchange(nums, i, j);
         }
         exchange(nums, lo, j);
         return j;
      }

      private void exchange(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
      }

      private boolean less(int val1, int val2) {
         String text1 = "" + val1 + val2;
         String text2 = "" + val2 + val1;
         return text1.compareTo(text2) < 0;
      }

      public String largestNumber(int[] nums) {
         if(nums.length == 0) return "0";
         if(nums.length == 1) return "" + nums[0];
         quickSort(nums, 0, nums.length-1);
         StringBuilder sb = new StringBuilder();
         int count = 0;
         for(int i=0; i < nums.length; ++i) {
            if(count == 0) count+=nums[i];
            if(count > 0) {
               sb.append(nums[i]);
            }
         }
         if(count == 0) {
            sb.append("0");
         }
         return trim(sb.toString());
      }
      private String trim(String s) {
         boolean zeroStart = true;
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < s.length(); ++i) {

            if(s.charAt(i)!='0') {
               zeroStart = false;
               sb.append(s.charAt(i));
            } else {
               if(!zeroStart) {
                  sb.append(s.charAt(i));
               }
            }
         }

         s = sb.toString();
         if(s.length() == 0) return "0";
         return s;
      }
   }
}
