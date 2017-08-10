package com.github.chen0040.leetcode.day15.medium;


import java.util.Stack;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://leetcode.com/problems/solve-the-equation/description/
 */
public class SolveTheEquation {
   public class Solution {
      public String solveEquation(String equation) {
         StringBuilder sb = new StringBuilder();
         Stack<String> stack =new Stack<String>();
         boolean passEqual = false;
         for(int i=0; i < equation.length(); ++i) {
            char c = equation.charAt(i);
            if("+-=".indexOf(c) != -1) {
               String prev = sb.toString();
               if(prev.length() == 0) prev = "0";
               stack.push(prev);
               sb = new StringBuilder();

               if("+-".indexOf(c) != -1) {
                  if(passEqual) {
                     if(c == '+') stack.push("-");
                     else stack.push("+");
                  } else {
                     stack.push("" + c);
                  }
               } else {
                  passEqual = true;
                  if("+-".indexOf(equation.charAt(i+1)) == -1){
                     stack.push("-");
                  }
               }
            } else {
               sb.append(c);
            }
         }

         stack.push(sb.toString());

         int xCount = 0;
         int vCount = 0;
         String buffer = null;
         while(!stack.isEmpty()) {
            String item = stack.pop();
            if(item.equals("+")){
               if(buffer.endsWith("x")) {
                  String x = buffer.substring(0, buffer.length()-1);
                  if(x.length() > 0){
                     xCount += Integer.parseInt(x);
                  } else {
                     xCount += 1;
                  }
               } else {
                  vCount += Integer.parseInt(buffer);
               }
            } else if(item.equals("-")) {
               if(buffer.endsWith("x")) {
                  String x = buffer.substring(0, buffer.length()-1);
                  if(x.length() > 0){
                     xCount -= Integer.parseInt(x);
                  } else {
                     xCount -= 1;
                  }
               } else {
                  vCount -= Integer.parseInt(buffer);
               }
            } else {
               buffer = item;
            }
         }

         if(buffer.endsWith("x")) {
            String x = buffer.substring(0, buffer.length()-1);
            if(x.length() > 0){
               xCount += Integer.parseInt(x);
            } else {
               xCount += 1;
            }
         } else {
            vCount += Integer.parseInt(buffer);
         }


         if(vCount == 0) {
            if(xCount == 0) {
               return "Infinite solutions";
            } else {
               return "x=0";
            }
         } else {
            if(xCount == 0) {
               return "No solution";
            } else {
               return "x=" + (-vCount / xCount);
            }
         }
      }
   }
}
