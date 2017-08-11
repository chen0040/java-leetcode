package com.github.chen0040.leetcode.day16.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
 */
public class ReconstructOriginalDigitsFromEnglish {
   public class Solution {

      private void cleanup(Map<Character, Integer> counts) {
         List<Character> keys = new ArrayList<Character>(counts.keySet());
         for(Character key : keys) {
            if(counts.get(key).intValue() == 0) {
               counts.remove(key);
            }
         }
      }
      public String originalDigits(String s) {

         Map<Character, Integer> counts = new HashMap<Character, Integer>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0)+ 1);
         }
         int count0 = 0;
         if(counts.containsKey('z')) {
            count0 = counts.get('z');
            counts.remove('z');
            counts.put('e', counts.get('e') - count0);
            counts.put('r', counts.get('r') - count0);
            counts.put('o', counts.get('o') - count0);
            cleanup(counts);
         }

         int count8 = 0;
         if(counts.containsKey('g')) {
            count8 = counts.get('g');
            counts.remove('g');
            counts.put('e', counts.get('e') - count8);
            counts.put('i', counts.get('i') - count8);
            counts.put('h', counts.get('h') - count8);
            counts.put('t', counts.get('t') - count8);
            cleanup(counts);
         }
         int count6 = 0;
         if(counts.containsKey('x')) {
            count6 = counts.get('x');
            counts.remove('x');
            counts.put('s', counts.get('s') - count6);
            counts.put('i', counts.get('i') - count6);
            cleanup(counts);
         }

         int count2 = 0;
         if(counts.containsKey('w')) {
            count2 = counts.get('w');
            counts.remove('w');
            counts.put('t', counts.get('t') - count2);
            counts.put('o', counts.get('o') - count2);
            cleanup(counts);
         }
         int count7 = 0;
         if(counts.containsKey('s')) {
            count7 = counts.get('s');
            counts.remove('s');
            counts.put('v', counts.get('v') - count7);
            counts.put('e', counts.get('e') - count7 * 2);
            counts.put('n', counts.get('n') - count7);
            cleanup(counts);
         }

         int count5 = 0;
         if(counts.containsKey('v') && counts.containsKey('v')) {
            count5 = counts.get('v');
            counts.remove('v');
            counts.put('f', counts.get('f') - count5);
            counts.put('i', counts.get('i') - count5);
            counts.put('e', counts.get('e') - count5);
            cleanup(counts);
         }
         int count4 = 0;
         if(counts.containsKey('u')) {
            count4 = counts.get('u');
            counts.remove('u');
            counts.put('r', counts.get('r') - count4);
            counts.put('o', counts.get('o') - count4);
            counts.put('f', counts.get('f') - count4);
            cleanup(counts);
         }
         int count3 = 0;
         if(counts.containsKey('t')) {
            count3 = counts.get('t');
            counts.remove('t');
            counts.put('r', counts.get('r') - count3);
            counts.put('e', counts.get('e') - count3 * 2);
            counts.put('h', counts.get('h') - count3);
            cleanup(counts);
         }
         int count1 = 0;
         if(counts.containsKey('o')) {
            count1 = counts.get('o');
            counts.remove('o');
            counts.put('n', counts.get('n') - count1);
            counts.put('e', counts.get('e') - count1);
            cleanup(counts);
         }
         int count9 = 0;
         if(counts.containsKey('n')) {
            count9 = counts.get('n') / 2;
         }

         int[] dcounts = { count0, count1, count2, count3, count4, count5, count6, count7, count8, count9 };
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < dcounts.length; ++i) {
            int dcount = dcounts[i];
            for(int j=0; j < dcount; ++j) {
               sb.append(i);
            }
         }

         return sb.toString();

      }
   }
}
