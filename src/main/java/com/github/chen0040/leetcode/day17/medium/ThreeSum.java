package com.github.chen0040.leetcode.day17.medium;


import java.util.*;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
   public class Solution {
      public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> result = new ArrayList<List<Integer>>();

         Map<Integer, Integer> taboo = new HashMap<Integer, Integer>();
         int prev1 = Integer.MIN_VALUE;
         for(int i=0; i < nums.length-2; ++i) {
            int num1 = nums[i];
            if(prev1 == num1) continue;
            prev1 = num1;
            int prev = Integer.MIN_VALUE;
            for(int j = i+1; j < nums.length-1; ++j){
               int num2 = nums[j];
               if(num2 == prev) {
                  continue;
               }
               prev = num2;

               int sum = num1 + num2;
               int sum_neg = - sum;
               int index = Arrays.binarySearch(nums, j+1, nums.length, sum_neg);

               if(index >= 0 && !(taboo.containsKey(num2) && taboo.get(num2).intValue() == nums[index])) {
                  List<Integer> res = new ArrayList<Integer>();

                  res.add(num1);
                  res.add(num2);
                  res.add(nums[index]);
                  taboo.put(nums[index], num2);

                  result.add(res);
               }

            }
         }

         return result;
      }
   }
}
