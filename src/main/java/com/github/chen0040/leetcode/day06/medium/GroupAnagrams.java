package com.github.chen0040.leetcode.day06.medium;


import java.util.*;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given an array of strings, group anagrams together.
 *
 * link: https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {
   public class Solution {
      private String sort(String str) {
         Character[] chars = new Character[str.length()];
         for (int i = 0; i < chars.length; i++)
            chars[i] = str.charAt(i);
         Arrays.sort(chars);
         StringBuilder sb = new StringBuilder(chars.length);
         for (char c : chars) sb.append(c);
         return sb.toString();
      }
      public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> group = new HashMap<String, List<String>>();
         for(int i=0; i < strs.length; ++i) {
            String str = sort(strs[i]);
            if(group.containsKey(str)){
               group.get(str).add(strs[i]);
            } else {
               List<String> g = new ArrayList<String>();
               g.add(strs[i]);
               group.put(str, g);
            }
         }
         return new ArrayList<List<String>>(group.values());
      }
   }
}
