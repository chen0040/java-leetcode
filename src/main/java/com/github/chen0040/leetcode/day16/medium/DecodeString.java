package com.github.chen0040.leetcode.day16.medium;


import java.util.Stack;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/decode-string/description/
 */
public class DecodeString {
   public class Solution {
      public String decodeString(String s) {
         Stack<Character> stack = new Stack<Character>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == ']') {
               StringBuilder sb = new StringBuilder();
               String buffer = "";
               while(!stack.isEmpty()) {
                  char c2 = stack.pop();
                  if(c2 == '[') {
                     sb.reverse();
                     buffer = sb.toString();
                     break;
                  } else {
                     sb.append(c2);
                  }
               }
               sb = new StringBuilder();
               while(!stack.isEmpty()) {
                  if("0123456789".indexOf(stack.peek()) == -1){
                     break;
                  } else {
                     sb.append(stack.pop());
                  }
               }
               sb.reverse();
               int repeatCount = Integer.parseInt(sb.toString());

               for(int j=0; j < repeatCount; ++j) {
                  for(int k = 0; k < buffer.length(); ++k) {
                     stack.push(buffer.charAt(k));
                  }
               }
            } else {
               stack.push(c);
            }
         }

         StringBuilder sb2 = new StringBuilder();
         while(!stack.isEmpty()) {
            sb2.append(stack.pop());
         }
         sb2.reverse();

         return sb2.toString();
      }
   }
}
