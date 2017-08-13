package com.github.chen0040.leetcode.day06.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStockII {
   public class Solution {

      private int NO_ACTION = 0;
      private int BUY = 1;
      private int SELL = 2;
      private Map<Integer, Integer> states;

      public int maxProfit(int[] prices) {
         states = new HashMap<Integer, Integer>();
         for(int d = prices.length-1; d >= 1; --d) {
            states.put(d * 3 + BUY, test(prices, 0, d, BUY));
            states.put(d * 3 + SELL, test(prices, 0, d, SELL));
            states.put(d * 3 + NO_ACTION, test(prices, 0, d, NO_ACTION));
         }
         return test(prices, 0, 0, NO_ACTION);
      }

      private int test(int[] prices, int profit, int d, int lastAction){
         if(d == prices.length) {
            if(lastAction == BUY) {
               return 0;
            }
            return profit;
         }

         int newProfit = profit;
         int d2 = d + 1;
         if(d == prices.length-1) {
            if(lastAction == BUY ){
               newProfit = Math.max(newProfit, profit + prices[d]);
            } else {
               newProfit = Math.max(newProfit, profit);
            }
         } else {
            if(lastAction == BUY) {
               newProfit = Math.max(newProfit, profit + states.getOrDefault(d2 * 3 + lastAction, 0));
               newProfit = Math.max(newProfit, profit + prices[d] + states.getOrDefault(d2 * 3 + SELL, 0));
            } else {
               newProfit = Math.max(newProfit, profit + states.getOrDefault(d2 * 3 + lastAction, 0));
               newProfit = Math.max(newProfit, profit - prices[d] + states.getOrDefault(d2 * 3 + BUY, 0));
            }
         }
         return newProfit;
      }

   }
}
