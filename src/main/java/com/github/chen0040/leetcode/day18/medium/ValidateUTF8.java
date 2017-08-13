package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/utf-8-validation/description/
 */
public class ValidateUTF8 {
   public class Solution {
      public boolean validUtf8(int[] data) {
         for(int i=0; i < data.length; ++i) {
            if(!isOneByte(data[i])) {
               int k = 0;
               for(; k <= 4; ++k) { // first n-bits must be zero for first byte
                  if(((data[i] >> (7 - k)) & 1) == 0) {
                     break;
                  }
               }
               //System.out.println("k: " + k);
               if(k < 2) return false;
               if(k == 5) return false;

               for(int d = 1; d < k; ++d) {
                  if(d + i > data.length-1) return false;
                  if(((data[d+i] >> 7) & 1) == 0) return false;
                  if(((data[d+i] >> 6) & 1) == 1) return false;
               }
               i+=(k-1);
            }
         }
         return true;
      }

      private boolean isOneByte(int data){
         return ((data >> 7) & 1) == 0;
      }
   }
}
