package com.github.chen0040.leetcode.day17.medium;


import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by xschen on 12/8/2017.
 *
 * link: https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 */
public class EncodeAndDecodeTinyURL {
   public class Codec {

      // Encodes a URL to a shortened URL.
      public String encode(String longUrl) {
         Queue<Boolean> bitStream = new LinkedList<Boolean>();
         for(int i=0; i < longUrl.length(); ++i) {
            int d = (int)longUrl.charAt(i);

            for(int k = 0;  k < 7; ++k) {
               bitStream.add((d & 1) > 0);
               d >>= 1;
            }
         }
         int count = 0;
         int ch = 0;
         StringBuilder sb = new StringBuilder();
         while(!bitStream.isEmpty()) {
            count++;
            ch = (ch << 1) + (bitStream.remove() ? 1 : 0);
            if(count % 8 == 0) {
               sb.append((char)ch);
               ch = 0;
               count = 0;
            }
         }
         if(count < 8) {
            while(count < 8) {
               ch = (ch << 1) + 0;
               count++;
            }
            sb.append((char)ch);
         }
         return sb.toString();
      }


      // Decodes a shortened URL to its original URL.
      public String decode(String shortUrl) {
         Queue<Boolean> bitStream = new LinkedList<Boolean>();
         for(int i=0; i < shortUrl.length(); ++i) {
            int d = (int)shortUrl.charAt(i);
            for(int k = 0; k < 8; ++k) {
               bitStream.add((d & (1 << 7)) > 0);
               d <<= 1;
            }
         }
         int count = 0;
         int ch = 0;
         StringBuilder sb = new StringBuilder();
         while(!bitStream.isEmpty()) {
            ch = ch + ((bitStream.remove() ? 1 : 0) << count);
            count++;
            if(count % 7 == 0) {
               if(ch != 0){
                  sb.append((char)ch);
               }
               ch = 0;
               count = 0;
            }
         }
         return sb.toString();
      }
   }

}
