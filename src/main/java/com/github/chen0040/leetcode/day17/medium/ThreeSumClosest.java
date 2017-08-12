package com.github.chen0040.leetcode.day17.medium;


import java.util.Arrays;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {
   public class Solution {
      public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
         int prev1 = Integer.MIN_VALUE;
         int result = 0;
         int minDiff = Integer.MAX_VALUE;
         for(int i=0; i < nums.length-2; ++i) {
            int num1 = nums[i];
            int prev2 = Integer.MIN_VALUE;
            for(int j=i+1; j < nums.length-1; ++j) {
               int num2 = nums[j];
               int target_neg = target - num1 - num2;

               int lo = j+1;
               int hi = nums.length-1;
               int val = Integer.MIN_VALUE;
               while(lo <= hi) {
                  int mid = lo + (hi - lo) / 2;
                  if(nums[mid] < target_neg) {
                     if(nums[hi] >= target_neg) {
                        if(nums[mid+1] >= target_neg) {
                           if(Math.abs(target_neg - nums[mid]) < Math.abs(target_neg - nums[mid+1])) {
                              val = nums[mid];
                           } else {
                              val = nums[mid+1];
                           }
                           break;
                        } else {
                           lo = mid+1;
                        }
                     } else {
                        val = nums[hi];
                        break;
                     }
                  } else if(nums[mid] == target_neg) {
                     return target;
                  } else {
                     if(nums[lo] <= target_neg) {
                        if(nums[mid-1] <= target_neg) {
                           if(Math.abs(target_neg - nums[mid]) < Math.abs(target_neg - nums[mid-1])) {
                              val = nums[mid];
                           } else {
                              val = nums[mid-1];
                           }
                           break;
                        } else {
                           hi = mid - 1;
                        }
                     } else {
                        val = nums[lo];
                        break;
                     }
                  }
               }

               int candidate = num1 + num2 + val;

               //System.out.println(num1 + ", " + num2 + ", " + val);
               int diff = Math.abs(target - candidate);
               if(diff < minDiff) {
                  minDiff = diff;
                  result = candidate;
               }
            }
         }
         return result;
      }


   }
}
