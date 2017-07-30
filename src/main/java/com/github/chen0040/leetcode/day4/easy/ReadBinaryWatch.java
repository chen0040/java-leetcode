package com.github.chen0040.leetcode.day4.easy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by xschen on 30/7/2017.
 *
 * summary:
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 * link: https://leetcode.com/problems/binary-watch/description/
 */
public class ReadBinaryWatch {

   public class Solution {
      public List<String> readBinaryWatch(int num) {
         List<String> result = new ArrayList<String>();
         for(int hours = 0; hours < 12; ++hours) {
            for(int minutes = 0; minutes < 60; ++minutes) {
               int time = hours * 64 + minutes;
               if(Integer.bitCount(time) == num) {
                  result.add(hours + ":" + pad(minutes));
               }
            }
         }
         return result;
      }




      private String pad(int time){
         String text = "" + time;
         if(text.length() < 2) {
            text = "0" + text;
         }
         return text;
      }

   }

   public static void main(String[] args) {
      Solution2 s = new Solution2();
      List<String> result = s.readBinaryWatch(1);
      for(String d : result) {
         System.out.println(d);
      }
   }
   public static class Solution2 {

      public List<String> readBinaryWatch(int num) {
         Set<String> queue = new HashSet<String>();
         int[] permutation = new int[10];
         for(int i=0; i < num; ++i) {
            permutation[i] = 1;
         }
         permutate(permutation, queue);
         return new ArrayList<String>(queue);
      }
      private void permutate(int[] permutation, Set<String> queue) {
         List<List<Integer>> perms = new ArrayList<List<Integer>>();
         perms.add(new ArrayList<Integer>());
         perms = permutate(permutation, perms, 0);
         for(List<Integer> p : perms) {
            String time = getString(p);
            if(time != null) {
               queue.add(time);
            }
         }
      }

      private String getString(List<Integer> p) {
         int minutes = 0;
         for(int i=0; i < 6; ++i) {
            int bit = p.get(i);
            minutes += bit * Math.pow(2, i);
         }
         int hours = 0;
         for(int i=0; i < 4; ++i) {
            int bit = p.get(i + 6);
            hours += bit * Math.pow(2, i);
         }
         if(minutes >= 60) return null;
         if(hours >= 12) return null;
         return hours + ":" + pad(minutes);
      }

      private String pad(int time){
         String text = "" + time;
         if(text.length() < 2) {
            text = "0" + text;
         }
         return text;
      }

      private List<List<Integer>> permutate(int[] permutation, List<List<Integer>> perms, int d) {
         if(d == permutation.length) {
            return perms;
         }
         int val = permutation[d];
         List<List<Integer>> newPerms = new ArrayList<List<Integer>>();
         for(List<Integer> p : perms) {
            List<List<Integer>> genp = generate(p, val);
            newPerms.addAll(genp);
         }
         return permutate(permutation, newPerms, d+1);
      }

      private List<List<Integer>> generate(List<Integer> p, int val) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         for(int i=0; i < p.size(); ++i) {
            result.add(insert(p, i, val));
         }
         result.add(insert(p, p.size(), val));
         return result;
      }

      private List<Integer> insert(List<Integer> p, int i, int val) {
         List<Integer> newp =new ArrayList<Integer>();
         for(int j=0; j < p.size(); ++j) {
            if(i == j) {
               newp.add(val);
            }
            newp.add(p.get(j));
         }
         if(i == p.size()) {
            newp.add(val);
         }
         return newp;
      }

   }
}
