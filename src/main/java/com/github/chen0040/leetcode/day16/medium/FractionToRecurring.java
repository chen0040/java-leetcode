package com.github.chen0040.leetcode.day16.medium;


import java.util.HashMap;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 */
public class FractionToRecurring {
   public class Solution {
      public String fractionToDecimal(int num, int denom) {
         long numerator = num;
         long denominator = denom;

         boolean diffSign = numerator * denominator < 0;

         numerator = Math.abs(numerator);
         denominator = Math.abs(denominator);

         long whole_part = numerator / denominator;
         long dec_part = numerator % denominator;

         StringBuilder sb = new StringBuilder();
         sb.append(whole_part);

         long prev = -1;
         HashMap<Long, Integer> dec_pat = new HashMap<Long, Integer>();
         dec_pat.put(dec_part, 0);
         int d = 0;
         int duplicate_count = 0;
         while(dec_part > 0) {
            long digit = (dec_part * 10) / denominator;
            if(prev == -1) {
               sb.append(".");
            } else {
               sb.append(prev);
            }
            long new_dec_part = (dec_part * 10) % denominator;
            prev = digit;

            d++;

            if(dec_pat.containsKey(new_dec_part)) {
               duplicate_count = d - dec_pat.get(new_dec_part);
               break;
            } else {
               dec_part = new_dec_part;
               dec_pat.put(dec_part, d);
            }
         }

         if(prev != -1) {
            sb.append(prev);
         }



         String s = sb.toString();

         if(duplicate_count > 0) {
            s = s.substring(0, s.length()-duplicate_count) + "(" + s.substring(s.length()-duplicate_count) + ")";
         }

         if(diffSign) {
            return "-" + s;
         }

         return s;
      }
   }
}
