package com.github.chen0040.leetcode.day17.medium;


import java.util.Stack;


/**
 * Created by xschen on 12/8/2017.
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {
   public class Solution {
      public int evalRPN(String[] tokens) {
         if(tokens.length==0) return 0;
         Stack<String> stack = new Stack<String>();
         for(int i=0; i < tokens.length; ++i){
            String w = tokens[i];
            if("+-*/".indexOf(w) != -1) {
               Integer num2 = Integer.parseInt(stack.pop());
               Integer num1 = Integer.parseInt(stack.pop());
               int result = apply(num1, num2, w);
               stack.push("" + result);
            } else {
               stack.push(w);
            }
         }

         return Integer.parseInt(stack.pop());
      }

      private int apply(int num1, int num2, String op) {
         if(op.equals("+")) return num1 + num2;
         else if(op.equals("-")) return num1 - num2;
         else if(op.equals("*")) return num1 * num2;
         else return num1 / num2;
      }
   }
}
