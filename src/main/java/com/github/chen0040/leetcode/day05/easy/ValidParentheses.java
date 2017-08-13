package com.github.chen0040.leetcode.day05.easy;


import java.util.Stack;


/**
 * Created by xschen on 31/7/2017.
 *
 * summary:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * link: https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
   public class Solution {
      private boolean isOpen(char c) {
         return c == '(' || c == '{' || c == '[';
      }

      private boolean matched(char c1, char c2) {
         if(c1 == '(') return c2 == ')';
         if(c1 == '{') return c2 == '}';
         if(c1 == '[') return c2 == ']';
         return false;
      }

      public boolean isValid(String s) {
         if(s.equals("")) return true;

         Stack<Character> stack = new Stack<Character>();
         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(isOpen(c)){
               if(i == s.length()-1) {
                  return false;
               }
               stack.push(c);
            } else {
               if(stack.isEmpty()) return false;
               char c1 = stack.pop();
               if(!matched(c1, c)) {
                  return false;
               }
            }
         }
         return stack.isEmpty();
      }
   }
}
