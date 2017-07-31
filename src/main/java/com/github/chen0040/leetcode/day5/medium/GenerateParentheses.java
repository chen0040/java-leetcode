package com.github.chen0040.leetcode.day5.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * link: https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
   public class Solution {
      private List<String> result;
      public List<String> generateParenthesis(int n) {
         result = new ArrayList<String>();
         generate("", n, 0);
         return result;
      }
      private void generate(String prefix, int remaining, int onStack) {
         if(remaining == 0 && onStack == 0) {
            result.add(prefix);
         }
         if(remaining > 0) {
            generate(prefix +"(", remaining-1, onStack+1);
         }
         if(onStack > 0) {
            generate(prefix + ")", remaining, onStack - 1);
         }
      }
   }
}
