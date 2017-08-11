package com.github.chen0040.leetcode.day16.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Created by xschen on 11/8/2017.
 *
 * link: https://leetcode.com/problems/mini-parser/description/
 */
public class MiniParser {
    public class NestedInteger {
       private Integer value = null;
       private List<NestedInteger> list = new ArrayList<>();
      // Constructor initializes an empty nested list.
              public NestedInteger() {

              }

              // Constructor initializes a single integer.
              public NestedInteger(int value){
                 this.value = value;
              }

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger() {
                 return value != null;
              }

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger() {
                 return value;
              }

              // Set this NestedInteger to hold a single integer.
              public void setInteger(int value) {
                 this.value = value;
              }

              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni) {
                 list.add(ni);
              }

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList(){
                 return list;
              }
  }

   public class Solution {
      public NestedInteger deserialize(String s) {
         Stack<Object> stack = new Stack<Object>();


         for(int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == ']'){
               NestedInteger x = parse(stack);
               stack.push(x);
            } else {
               stack.push(c);
            }
         }

         return parse(stack);
      }

      private NestedInteger parse(Stack<Object> stack) {
         NestedInteger root = new NestedInteger();
         Stack<NestedInteger> buffer = new Stack<NestedInteger>();
         StringBuilder sb = new StringBuilder();


         while(!stack.isEmpty()) {
            Object obj = stack.pop();

            if(obj instanceof Character){
               char c2 = ((Character)obj);
               if(c2 == '[') {
                  sb.reverse();
                  String end = sb.toString();
                  if(!end.equals("")) {
                     int num = Integer.parseInt(end);
                     NestedInteger ni = new NestedInteger(num);
                     buffer.add(ni);
                  }

                  root = new NestedInteger();
                  while(!buffer.isEmpty()) {
                     NestedInteger ni = buffer.pop();
                     root.add(ni);
                  }
                  return root;
               } else if(c2 == ',') {
                  sb.reverse();
                  String content = sb.toString();
                  sb = new StringBuilder();
                  if(!content.equals("")) {
                     int num = Integer.parseInt(content);
                     NestedInteger ni = new NestedInteger(num);
                     buffer.add(ni);
                  }
               } else {
                  sb.append(c2);
               }
            } else {
               NestedInteger ni = (NestedInteger)obj;
               if(buffer.isEmpty() && stack.isEmpty()) {
                  return ni;
               } else {
                  buffer.push(ni);
               }
            }
         }

         sb.reverse();
         return new NestedInteger(Integer.parseInt(sb.toString()));



      }

   }
}
