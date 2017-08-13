package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/license-key-formatting/description/
 */
public class LicenseKeyFormatting {
   public class Solution {
      public String licenseKeyFormatting(String S, int K) {
         S = S.toUpperCase().replace("-", "");
         char[] a = S.toCharArray();

         StringBuilder sb = new StringBuilder();
         int count = 0;
         for(int i = a.length-1; i >= 0; --i) {

            sb.append(a[i]);
            count++;
            if(i!=0 && count % K == 0) {
               sb.append('-');
            }

         }
         sb.reverse();
         return sb.toString();
      }
   }
}
