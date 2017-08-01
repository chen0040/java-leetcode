package com.github.chen0040.leetcode.day6.easy;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {
   public class Solution {
      public int maxProfit(int[] prices) {
         int maxPrice = Integer.MIN_VALUE;
         int[] maxPrices = new int[prices.length];
         for(int i= prices.length-1; i > 0; --i) {
            int price = prices[i];
            if(price > maxPrice){
               maxPrice = price;
            }
            maxPrices[i-1] = maxPrice;
         }
         int maxProfit = 0;
         for(int i=0; i < prices.length-1; ++i) {
            int buy_cost = prices[i];
            int sell_gain = maxPrices[i];
            int gain = sell_gain - buy_cost;
            maxProfit = Math.max(maxProfit, gain);
         }
         return maxProfit;
      }
   }
}
