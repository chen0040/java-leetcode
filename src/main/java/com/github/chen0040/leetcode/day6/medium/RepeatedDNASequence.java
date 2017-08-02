package com.github.chen0040.leetcode.day6.medium;


import java.util.*;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * link: https://leetcode.com/problems/repeated-dna-sequences/description/
 */
public class RepeatedDNASequence {
   public class Solution {
      public List<String> findRepeatedDnaSequences(String s) {
         if(s.length() < 10) return new ArrayList<String>();
         Set<String> set = new HashSet<String>();
         ArrayList<String> a = new ArrayList<String>();
         for(int i = 0; i < s.length(); ++i){
            String str = s.substring(i, Math.min(i+10, s.length()));
            if(str.length() < 10)  continue;
            a.add(str);
         }
         //Arrays.sort(a);
         Collections.sort(a);

         for(int i=0; i < a.size()-1; ++i) {
            String csq = common10(a.get(i), a.get(i+1));
            if(csq != null) {
               set.add(csq);
            }
         }
         return new ArrayList<String>(set);
      }

      private String common10(String s1, String s2) {
         //if(s1.length() < 10 || s2.length() < 10) return null;
         StringBuilder sb = new StringBuilder();

         for(int i=0; i < 10; ++i) {
            if(s1.charAt(i) != s2.charAt(i)) {
               return null;
            }
            sb.append(s1.charAt(i));
         }
         return sb.toString();
      }
   }
}
