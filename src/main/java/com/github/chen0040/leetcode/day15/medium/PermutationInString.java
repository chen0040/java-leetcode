package com.github.chen0040.leetcode.day15.medium;


import java.util.Arrays;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/permutation-in-string/description/
 */
public class PermutationInString {
   public class Solution {
      public boolean checkInclusion(String s1, String s2) {
         char[] c1 = s1.toCharArray();
         Arrays.sort(c1);

         for(int i=0; i <= s2.length() - s1.length(); ++i) {
            String t = s2.substring(i, i + s1.length());
            char[] c2 = t.toCharArray();
            Arrays.sort(c2);
            boolean inclusion = true;
            for(int k = 0; k < s1.length(); ++k) {
               if(c1[k] != c2[k]){
                  inclusion = false;
                  break;
               }
            }
            if(inclusion) return true;
         }

         return false;
      }
   }
}
