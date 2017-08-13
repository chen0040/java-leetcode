package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 */
public class MaximumProductOfWordLength {
   public class Solution {
      public int maxProduct(String[] words) {
         int[][] vectors = new int[words.length][];
         for(int i=0; i < words.length; ++i) {
            String word = words[i];
            int[] vec = new int[26];
            for(int j = 0; j < word.length(); ++j){
               int d = (int)word.charAt(j) - (int)'a';
               vec[d] = 1;
            }
            vectors[i] = vec;
         }

         int maxLength = 0;
         for(int i=0; i < words.length; ++i) {
            for(int j=i+1; j < words.length; ++j){
               int dp = 0;
               for(int k=0; k < 26; ++k){
                  dp += vectors[i][k] * vectors[j][k];
               }
               if(dp == 0) {
                  maxLength = Math.max(maxLength, words[i].length() * words[j].length());
               }
            }
         }

         return maxLength;
      }
   }
}
