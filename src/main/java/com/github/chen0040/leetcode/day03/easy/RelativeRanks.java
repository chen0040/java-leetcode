package com.github.chen0040.leetcode.day03.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * link: https://leetcode.com/problems/relative-ranks/description/
 */
public class RelativeRanks {
   public class Solution {
      private void quickSort(int[] nums, int lo, int hi) {
         if(lo >= hi) return;

         int j = partition(nums, lo, hi);
         quickSort(nums, lo, j-1);
         quickSort(nums, j+1, hi);
      }

      private int partition(int[] nums, int lo, int hi) {
         int i=lo, j=hi+1;
         int v = nums[lo];
         while(true) {
            while(v < nums[++i]) {
               if(i >= hi) break;
            }
            while(v > nums[--j]) {
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

      public String[] findRelativeRanks(int[] nums) {
         int[] orders = new int[nums.length];
         for(int i=0; i < orders.length; ++i) {
            orders[i] = nums[i];
         }
         quickSort(orders, 0, orders.length-1);
         String[] result = new String[orders.length];
         Map<Integer, String> awards = new HashMap<Integer, String>();
         for(int i=0; i < orders.length; ++i) {
            int score = orders[i];
            String award = getAward(i);
            awards.put(score, award);
         }
         for(int i=0; i < nums.length; ++i) {
            int score = nums[i];
            result[i] = awards.get(score);
         }
         return result;
      }

      private String getAward(int i) {
         if(i == 0) return "Gold Medal";
         else if(i == 1) return "Silver Medal";
         else if(i == 2) return "Bronze Medal";
         else {
            return "" + (i+1);
         }
      }
   }
}
