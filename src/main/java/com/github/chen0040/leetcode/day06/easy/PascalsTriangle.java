package com.github.chen0040.leetcode.day06.easy;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 1/8/2017.
 *
 * summary:
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * link: https://leetcode.com/problems/pascals-triangle/description/
 */
public class PascalsTriangle {
   public class Solution {
      public List<List<Integer>> generate(int numRows) {
         if(numRows == 0) return new ArrayList<List<Integer>>();
         List<List<Integer>> triangle = new ArrayList<List<Integer>>();
         List<Integer> arr = new ArrayList<Integer>();
         arr.add(1);
         triangle.add(arr);
         generate(triangle, numRows, 1);
         return triangle;
      }
      public void generate(List<List<Integer>> triangle, int numRows, int d) {
         if(d == numRows){
            return;
         }
         List<Integer> prev = triangle.get(d-1);
         int size = prev.size()+1;
         List<Integer> current = new ArrayList<Integer>();
         for(int i=0; i < size; ++i) {
            int j = i - 1;
            if(j < 0) {
               current.add(prev.get(i));
            } else if(i == size-1) {
               current.add(prev.get(j));
            } else {
               current.add(prev.get(j) + prev.get(i));
            }
         }
         triangle.add(current);
         generate(triangle, numRows, d+1);
      }
   }
}
