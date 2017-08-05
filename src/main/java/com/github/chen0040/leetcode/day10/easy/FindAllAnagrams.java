package com.github.chen0040.leetcode.day10.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 5/8/2017.
 *
 * summary:
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class FindAllAnagrams {
   public class Solution {
      public List<Integer> findAnagrams(String s, String p) {
         if(p.length()==0) return new ArrayList<Integer>();

         Map<Character, Integer> p_states = new HashMap<Character, Integer>();
         for(int i = 0; i < p.length(); ++i) {
            char c = p.charAt(i);
            p_states.put(c, p_states.getOrDefault(c, 0) + 1);
         }

         List<Integer> result = new ArrayList<Integer>();
         Map<Character, Integer> s_states = new HashMap<Character, Integer>();
         char prev_c = '0';
         for(int i=0; i < s.length(); ++i){
            char c = s.charAt(i);
            s_states.put(c, s_states.getOrDefault(c, 0) + 1);

            if(i >= p.length()-1){
               boolean anagram = true;
               for(Map.Entry<Character, Integer> entry : p_states.entrySet()){
                  char c2 = entry.getKey();
                  int count = entry.getValue();
                  if(!s_states.containsKey(c2)) {
                     anagram = false;
                     break;
                  }
                  if(s_states.get(c2).intValue() != count) {
                     anagram = false;
                     break;
                  }
               }
               if(anagram){
                  result.add(i - p.length() + 1);
               }

               prev_c = s.charAt(i-p.length()+1);
               if(s_states.containsKey(prev_c) && s_states.get(prev_c) > 1){
                  s_states.put(prev_c, s_states.get(prev_c) - 1);
               } else {
                  s_states.remove(prev_c);
               }
            }
         }

         return result;
      }

      private String getState(Map<Character, Integer> state){
         StringBuilder sb = new StringBuilder();
         for(Map.Entry<Character, Integer> entry : state.entrySet()) {
            sb.append(entry.getKey() + "" + entry.getValue());
         }
         return sb.toString();
      }
   }
}
