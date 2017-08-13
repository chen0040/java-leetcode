package com.github.chen0040.leetcode.day05.easy;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * link: https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInt {
   public class Solution {
      public int romanToInt(String s) {
         int[] nums = new int[s.length()];
         for(int i=0;i <s.length();i++){
            switch (s.charAt(i)){
               case 'M':
                  nums[i]=1000;
                  break;
               case 'D':
                  nums[i]=500;
                  break;
               case 'C':
                  nums[i]=100;
                  break;
               case 'L':
                  nums[i]=50;
                  break;
               case 'X' :
                  nums[i]=10;
                  break;
               case 'V':
                  nums[i]=5;
                  break;
               case 'I':
                  nums[i]=1;
                  break;
            }
         }
         int sum = 0;
         for(int i=0; i < nums.length-1; ++i) {
            if(nums[i] < nums[i+1]) {
               sum -= nums[i];
            } else {
               sum += nums[i];
            }
         }
         return sum + nums[nums.length-1];
      }
   }
}
