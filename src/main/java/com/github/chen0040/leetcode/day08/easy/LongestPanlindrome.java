package com.github.chen0040.leetcode.day08.easy;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * link: https://leetcode.com/problems/longest-palindrome/description/
 */
public class LongestPanlindrome {
   public class Solution {
      public int longestPalindrome(String s) {
         Map<Character, Integer> states = new HashMap<Character, Integer>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            states.put(c, states.getOrDefault(c, 0) + 1);
         }
         boolean oddFound = false;
         int result = 0;
         for(Map.Entry<Character, Integer> entry : states.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if(count % 2 == 1) {
               oddFound = true;
            }
            result += (count / 2) * 2;
         }
         if(oddFound) result++;
         return result;
      }
   }
}
