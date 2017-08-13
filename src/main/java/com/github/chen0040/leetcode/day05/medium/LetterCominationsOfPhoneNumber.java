package com.github.chen0040.leetcode.day05.medium;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCominationsOfPhoneNumber {
   public class Solution {
      public List<String> letterCombinations(String digits) {

         List<String> result = new ArrayList<String>();
         if(digits.length() == 0) return result;
         result.add("");
         return generate(result, digits, 0);
      }

      private String getMapping(char c) {
         if(c == '2') return "abc";
         if(c == '3') return "def";
         if(c == '4') return "ghi";
         if(c == '5') return "jkl";
         if(c == '6') return "mno";
         if(c == '7') return "pqrs";
         if(c == '8') return "tuv";
         if(c == '9') return "wxyz";
         return "";
      }

      private List<String> generate(List<String> sets, String digits, int d) {
         if(d == digits.length()) {
            return sets;
         }

         List<String> newSets = new ArrayList<String>();
         String options = getMapping(digits.charAt(d));
         for(int i=0; i < options.length(); ++i) {
            char c = options.charAt(i);
            newSets.addAll(generateNewSets(sets, c));
         }

         return generate(newSets, digits, d+1);
      }

      private List<String> generateNewSets(List<String> oldSets, char c){
         List<String> newSets = new ArrayList<String>();
         for(int i=0; i < oldSets.size(); ++i) {
            String prefix = oldSets.get(i);
            newSets.add(prefix + c);
         }
         return newSets;
      }
   }
}
