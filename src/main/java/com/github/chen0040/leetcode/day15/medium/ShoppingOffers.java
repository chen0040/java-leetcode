package com.github.chen0040.leetcode.day15.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/shopping-offers/description/
 */
public class ShoppingOffers {
   public class Solution {
      public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
         return calculate(price, special, needs, 0);
      }

      private int calculate(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int spent) {
         boolean more = false;
         for(Integer need : needs) {
            if(need.intValue() > 0) {
               more = true;
               break;
            }
         }
         if(!more) {
            return spent;
         }

         boolean specialApplied = false;
         int minSpent = Integer.MAX_VALUE;
         for(List<Integer> offer : special) {
            int cost = offer.get(offer.size()-1);
            boolean applied = true;
            for(int i=0; i < offer.size() - 1; ++i){
               if(needs.get(i) < offer.get(i)) {
                  applied = false;
               }
            }
            if(applied) {
               minSpent = Math.min(minSpent, calculate(price, special, minus(needs, offer), spent + cost));
               specialApplied = true;
            }
         }
         if(!specialApplied) {
            return calculate(price, special, zeroes(needs.size()), spent + paySingle(price, needs));
         } else {
            minSpent = Math.min(minSpent, calculate(price, special, zeroes(needs.size()), spent + paySingle(price, needs)));
         }

         return minSpent;
      }

      private List<Integer> minus(List<Integer> needs, List<Integer> offer) {
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i< needs.size();++i) {
            result.add(needs.get(i)  - offer.get(i));
         }
         return result;
      }

      private int paySingle(List<Integer> price, List<Integer> needs) {
         int sum = 0;
         for(int i=0; i < needs.size(); ++i) {
            sum += price.get(i) * needs.get(i);
         }
         return sum;
      }

      private List<Integer> zeroes(int len) {
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < len; ++i) {
            result.add(0);
         }
         return result;
      }
   }
}
