package com.github.chen0040.leetcode.day7.medium;


import java.util.Stack;


/**
 * Created by xschen on 2/8/2017.
 *
 * summary:
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * link: https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath {
   public class Solution {
      public String simplifyPath(String path) {
         String[] parts = path.split("/");
         Stack<String> stack = new Stack<String>();
         for(int i=0; i < parts.length; ++i) {
            String p = parts[i];
            if(p.equals("") || p.equals(".")) {
               continue;
            }
            if(p.equals("..")) {
               if(!stack.isEmpty())
                  stack.pop();
            } else {
               stack.push(p);
            }
         }
         String s = "";
         while(!stack.isEmpty()) {
            s = "/" + stack.pop() + s;
         }
         if(s.equals("")) {
            s = "/";
         }
         return s;
      }
   }
}
