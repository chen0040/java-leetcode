package com.github.chen0040.leetcode.day01.medium;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 29/7/2017.
 *
 * summary:
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * link: https://leetcode.com/problems/sort-characters-by-frequency/tabs/description
 */
public class SortCharactersByFrequency {
   public class Solution {
      private void mergeSort(char[] a, char[] aux, int lo, int hi, Map<Character, Integer> cFreq){
         if(lo >= hi) return;
         int mid = (lo + hi) / 2;
         mergeSort(a, aux, lo, mid, cFreq);
         mergeSort(a, aux, mid+1, hi, cFreq);
         merge(a, aux, lo, mid, hi, cFreq);
      }

      private void merge(char[] a, char[] aux, int lo, int mid, int hi, Map<Character, Integer> cFreq) {
         int i=lo, j=mid+1;
         for(int k=lo; k<= hi; ++k) {
            aux[k] = a[k];
         }
         for(int k=lo; k <= hi; ++k) {
            if(i == mid+1) {
               a[k] = aux[j++];
            }
            else if(j == hi + 1) {
               a[k] = aux[i++];
            }
            else if(cFreq.get(aux[i]) > cFreq.get(aux[j])) {
               a[k] = aux[i++];
            } else {
               a[k] = aux[j++];
            }
         }
      }

      public String frequencySort(String s) {
         Map<Character, Integer> cFreq = new HashMap<Character, Integer>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            cFreq.put(c, cFreq.getOrDefault(c, 0) + 1);
         }

         char[] a = new char[cFreq.size()];
         char[] aux = new char[cFreq.size()];
         int index = 0;
         for(Character c : cFreq.keySet()) {
            a[index++] = c;
         }
         mergeSort(a, aux, 0, a.length-1, cFreq);
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < a.length; ++i) {
            int count = cFreq.get(a[i]);
            for(int j=0; j < count; ++j) {
               sb.append(a[i]);
            }
         }
         return sb.toString();
      }
   }
}
