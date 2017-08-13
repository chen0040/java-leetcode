package com.github.chen0040.leetcode.day18.medium;


/**
 * Created by xschen on 13/8/2017.
 *
 * link: https://leetcode.com/problems/validate-ip-address/description/
 */
public class ValidateIPAddress {
   public class Solution {
      public String validIPAddress(String IP) {
         if(IP.indexOf('.') != -1) {
            if(isIpV4(IP)){
               return "IPv4";
            } else {
               return "Neither";
            }
         } else if(IP.indexOf(':') != -1) {
            if(isIpV6(IP)) {
               return "IPv6";
            } else {
               return "Neither";
            }
         } else {
            return "Neither";
         }
      }

      private boolean isIpV4(String ip) {
         String[] parts = ip.split("\\.", -1);
         if(parts.length != 4) return false;
         for(int i=0; i < parts.length; ++i) {
            try{
               if(parts[i].charAt(0)=='0' && parts[i].length() > 1) return false;
               int val = Integer.parseInt(parts[i]);
               if(val >= 256 || val < 0){
                  return false;
               }
               if(val == 0 && parts[i].length() > 1) return false;
            } catch(Exception ex) {
               return false;
            }
         }
         return true;
      }

      private boolean isIpV6(String ip) {
         String[] parts = ip.split(":", -1);
         if(parts.length != 8) return false;
         for(int i=0; i < parts.length; ++i) {
            String part = parts[i];
            if(part.length() == 0) return false;
            if(part.length() > 4) return false;
            if(i == 0 && part.charAt(0) == '0' && part.length() > 1) return false;
            for(int j=0; j < part.length(); ++j) {
               if("0123456789abcdefABCDEF".indexOf(part.charAt(j)) == -1) return false;
            }
         }
         return true;
      }
   }
}
