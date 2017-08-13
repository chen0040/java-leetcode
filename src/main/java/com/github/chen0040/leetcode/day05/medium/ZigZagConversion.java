package com.github.chen0040.leetcode.day05.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * link: https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {
   public class Solution {
      public String convert(String s, int numRows) {
         if(numRows <= 1) return s;
         List<List<Character>> zz = new ArrayList<List<Character>>();
         for(int i=0; i < numRows; ++i) {
            zz.add(new ArrayList<Character>());
         }
         int index = 0;
         int inc = 1;
         for(int i=0; i < s.length(); ++i) {
            zz.get(index).add(s.charAt(i));
            index += inc;
            if(index >= numRows) {
               index = numRows-2;
               inc *= (-1);
            } else if(index < 0) {
               index = 1;
               inc *= (-1);
            }
         }
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < numRows; ++i) {
            for(Character c : zz.get(i)){
               sb.append(c);
            }
         }
         return sb.toString();
      }
   }
}
