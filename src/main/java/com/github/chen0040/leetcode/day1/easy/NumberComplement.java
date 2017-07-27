package com.github.chen0040.leetcode.day1.easy;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 27/7/2017.
 *
 * summary:
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * link: https://leetcode.com/problems/number-complement/tabs/description
 */
public class NumberComplement
{
   public int findComplement(int num) {
      if(num == 0) return 1;
      int result = 0;
      List<Integer> list = new ArrayList<Integer>();
      while(num > 0) {
         if((num&1) == 0) {
            list.add(1);
         } else {
            list.add(0);
         }
         num >>= 1;
      }

      for(int i=list.size()-1; i >= 0; --i) {
         result <<= 1;
         result += list.get(i);
      }

      return result;
   }
}
