package com.github.chen0040.leetcode.day07.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * link: https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {
   public class Solution {
      Map<Integer, Integer> states_rob = new HashMap<Integer, Integer>();
      Map<Integer, Integer> states_rob_not = new HashMap<Integer, Integer>();
      public int rob(int[] nums) {

         for(int d = nums.length-1; d >= 0; --d) {
            states_rob.put(d, rob(nums, 0, d, d+1));
            states_rob_not.put(d, rob(nums, 0, d-1, d+1));
         }
         return rob(nums, 0, -100, 0);
      }
      private int rob(int[] nums, int amountSoFar, int prevHouseRobbed, int d){
         if(d == nums.length) {
            return amountSoFar;
         }
         int newAmount = amountSoFar;

         if(d - prevHouseRobbed > 1) {
            if(d == nums.length - 1) {
               newAmount = Math.max(newAmount,amountSoFar + nums[d]);
            } else {
               newAmount = Math.max(newAmount, amountSoFar + states_rob.get(d) + nums[d]);
               newAmount = Math.max(newAmount, amountSoFar + states_rob_not.get(d));
            }

         } else {
            newAmount = Math.max(newAmount, amountSoFar + states_rob_not.getOrDefault(d, 0));
         }
         return newAmount;
      }
   }
}
